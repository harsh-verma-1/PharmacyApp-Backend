package com.supplier.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supplier.exception.SupplierNotFoundException;
import com.supplier.model.Supplier;
import com.supplier.repository.SupplierRepository;

@Service
public class SupplierService {
	
	@Autowired
	private SupplierRepository supplierRepository;
		
	
	//add details of the supplier
	public Supplier addDetails(Supplier supplier) {
		return supplierRepository.save(supplier);	
	}
	
	
	//edit detials of the supplier
	public Supplier modifyDetails(Supplier supplier,int id) throws SupplierNotFoundException{
		Supplier sup = supplierRepository.findById(id).orElseThrow(()-> new SupplierNotFoundException("Supplier details not found"));
		
		Supplier s = new Supplier();
		s.setName(supplier.getName());
		s.setEmail(supplier.getEmail());
		s.setPhoneNumber(supplier.getPhoneNumber());
		s.setAddress(supplier.getAddress());
		
		return supplierRepository.save(s);
	}
	
	
	
	//get supplier detials by id
	public Supplier getById(int id) throws SupplierNotFoundException {
		Supplier supplier = supplierRepository.findById(id).orElseThrow(()-> new SupplierNotFoundException("Supplier details not found wiht Id:"+id));
		return supplier;
	}
	
	
	
	//get all supplier list(details)
	public List<Supplier> getAllSupplierList() throws SupplierNotFoundException{
		List<Supplier> listSupplier = supplierRepository.findAll();
		if(listSupplier.isEmpty()) {
			throw new SupplierNotFoundException("Not Supplier present in the database");
		}
		return listSupplier;
	}
	
	
	//delete details by id
	public String deleteById(int id) throws SupplierNotFoundException{
		Optional<Supplier> os = supplierRepository.findById(id);
		if(os.isPresent()) {
			Supplier supplier = os.get();
			supplierRepository.delete(supplier);
			return "User Deleted Successfully";
		}
		throw new SupplierNotFoundException("Supplier details not found");
	}
}
