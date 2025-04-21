package com.sales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sales.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Integer> {

}
