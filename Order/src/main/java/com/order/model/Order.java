package com.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Order_Table")
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private String doctorId;
	
	
	@Enumerated(EnumType.STRING)
	private Status orderStatus;
	
	
	private int drugId;
	private int orderQuantity;
	
}
