package com.pharmacy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.exception.DrugNotFoundException;
import com.pharmacy.model.Drug;
import com.pharmacy.repository.DrugRepository;

@Service
public class DrugService {

	@Autowired
	private DrugRepository drugRepository;
	
	
	
	public Drug addDrug(Drug drug) {
		return drugRepository.save(drug);
	}
	
	
	public Drug updateDrug(Drug drug,int id)throws DrugNotFoundException{
		Drug dr = drugRepository.findById(id).orElseThrow(()-> new DrugNotFoundException("Drug not Available"));
		
		Drug d = new Drug();
		d.setName(drug.getName());
		d.setDescription(drug.getDescription());
		d.setPrice(drug.getPrice());
		d.setStock(drug.getStock());
		return drugRepository.save(d);
	}
	
	
	public List<Drug> findAll() throws DrugNotFoundException{
		List<Drug> drug = drugRepository.findAll();
		
		if(drug.isEmpty()) {
			throw new DrugNotFoundException("Drug not Available");
		}
		return drug;
	}
	
	
	public Drug findById(int drugId) throws DrugNotFoundException{
		Drug drug = drugRepository.findById(drugId).orElseThrow(()-> new DrugNotFoundException("Drug not Available"));
		return drug;
	}
	
	
	public Drug delete(int drugId) throws DrugNotFoundException{
		Optional<Drug> drug = drugRepository.findById(drugId);
		
		if(drug.isPresent()) {
			Drug dr = drug.get();
			drugRepository.delete(dr);
			return null;
		}
		else {
			throw new DrugNotFoundException("Drug not Available");
		}
	}
}
