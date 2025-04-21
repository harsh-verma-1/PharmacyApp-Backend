package com.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supplier.exception.SupplierNotFoundException;
import com.supplier.model.Supplier;
import com.supplier.service.SupplierService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("supplier")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	
	//add supplier details
	@PostMapping("/addSupplierDetail")
	public ResponseEntity<Supplier> addSupplierDetails(@RequestBody Supplier supplier){
		return new ResponseEntity<Supplier>(supplierService.addDetails(supplier),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updateDetails/{id}")
	public ResponseEntity<Supplier> updateDetails(@RequestBody Supplier supplier, @PathVariable("id") Integer id) throws SupplierNotFoundException{
		return new ResponseEntity<Supplier>(supplierService.modifyDetails(supplier, id),HttpStatus.OK);
	}
	
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<Supplier> getById (@PathVariable("id") Integer id) throws SupplierNotFoundException {
		return new ResponseEntity<Supplier>(supplierService.getById(id),HttpStatus.OK);
	}
	
	
	@GetMapping("/allSupplierList")
	public ResponseEntity<List<Supplier>> getAllDetails() throws SupplierNotFoundException{
		return new ResponseEntity<List<Supplier>>(supplierService.getAllSupplierList(),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/byId/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws SupplierNotFoundException {
	    String message = supplierService.deleteById(id);
	    return new ResponseEntity<>(message, HttpStatus.OK);
	}
	
}
