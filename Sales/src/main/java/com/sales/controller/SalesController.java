package com.sales.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sales.model.Sales;

@RestController
@RequestMapping("sales/")
public class SalesController {

	@GetMapping("generate")
	public ResponseEntity<Sales> generateReport(){
		return null;
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<Sales> deleteReport(){
		return null;
	}
}
