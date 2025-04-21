package com.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.FeignClient.DrugFeignClient;
import com.order.exception.OrderNotFoundException;
import com.order.model.Order;
import com.order.model.Status;
import com.order.repository.OrderRepository;
import com.pharmacy.exception.DrugNotFoundException;
import com.pharmacy.model.Drug;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private DrugFeignClient drugFeignClient;
	
	
	
	//ADD ORDER DETAILS
	public Order addOrder(Order order) {
		
		//fetch the details from the drug service
		Drug drug = drugFeignClient.getById(order.getDrugId()).getBody();
		if(drug == null) {
			throw new RuntimeException("Drug Not Found");
		}
		
		if(drug.getStock()<order.getOrderQuantity()) {
			throw new RuntimeException("Not enough stock available for drug: "+drug.getName());
		}
		
		
		//update drug quantity in the drug service
		drug.setStock(drug.getStock() - order.getOrderQuantity());
		drugFeignClient.updateStock(order.getDrugId(), drug);
		
		order.setOrderStatus(Status.Pending);
		
		//save the details
		return orderRepository.save(order);
	}
	
	
	public Order editOrder(Order order, int orderId) throws OrderNotFoundException {
		
		Optional<Order> existingOrder = orderRepository.findById(orderId);
        
        if (existingOrder.isPresent()) {
            Order o = existingOrder.get();
			o.setOrderQuantity(order.getOrderQuantity());
			return orderRepository.save(o);
        }
        else
        	throw new OrderNotFoundException("Order does not exist");
	}
	
	public List<Order> getAllOrder() {
		List<Order> order = orderRepository.findAll();
		return order;
	}
	
	public Order getOrderById(int id) {
		Optional<Order> order = orderRepository.findById(id);
		
		if(order.isEmpty()) {
			return null;
		}
		else
			return order.get();
	}
	
	
	
	// check it for the deletion
	
	public Order deleteOrder(int orderId) throws OrderNotFoundException{
		Optional<Order> order = orderRepository.findById(orderId);
		
		if(order.isPresent()) {
			Order or = order.get();
			orderRepository.delete(or);
			return null;
		}
		else {
			throw new OrderNotFoundException("Order is not Available");
		}
	}
}
