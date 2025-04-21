package com.pharmacy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.model.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Integer>{

}
