package com.pharmacy.controller;

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

import com.pharmacy.exception.DrugNotFoundException;
import com.pharmacy.model.Drug;
import com.pharmacy.service.DrugService;

@RestController
@RequestMapping("drug")
public class DrugController {
	
	@Autowired
	DrugService drugService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Drug> addDrug(@RequestBody Drug drug){
		return new ResponseEntity<Drug>(drugService.addDrug(drug),HttpStatus.OK);
	}
	
	@PutMapping("/updateDrugById/{drugId}")
	public ResponseEntity<Drug> updateDrug(@PathVariable("drugId") int drugId,@RequestBody Drug drug) throws DrugNotFoundException{
		return new ResponseEntity<Drug>(drugService.updateDrug(drug, drugId),HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Drug>> findAllDrugs() throws DrugNotFoundException{
		return new ResponseEntity<List<Drug>>(drugService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/findById/{drugId}")
	public ResponseEntity<Drug> findById(@PathVariable("drugId") int drugId) throws DrugNotFoundException{
		return new ResponseEntity<Drug>(drugService.findById(drugId),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{drugId}")
	public ResponseEntity<Drug> deleteById(@PathVariable("drugId") int drugId) throws DrugNotFoundException{
		return new ResponseEntity<Drug>(drugService.delete(drugId),HttpStatus.OK);
				
	}
}




