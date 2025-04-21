package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.FeignClient.DrugFeignClient;
import com.order.exception.OrderNotFoundException;
import com.order.model.Order;
import com.order.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("addOrder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order){
		return new ResponseEntity<>(orderService.addOrder(order),HttpStatus.CREATED);
	}
	
	@PutMapping("updateOrder/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("id") int id) throws OrderNotFoundException{
		return new ResponseEntity<Order>(orderService.editOrder(order, id),HttpStatus.OK);
	}
	
	@GetMapping("byId/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Integer id){
		return new ResponseEntity<Order>(orderService.getOrderById(id),HttpStatus.OK);
	}
	
	@GetMapping("byAllOrder")
	public ResponseEntity<List<Order>> getAllOrder(){
		return new ResponseEntity<List<Order>>(orderService.getAllOrder(),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<Order> deleteById(@PathVariable("id") Integer id) throws OrderNotFoundException{
		return new ResponseEntity<Order>(orderService.deleteOrder(id),HttpStatus.OK);
	}
}
