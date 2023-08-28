package com.inventory.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sale")
public class SalesPojo {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date_Time")
	private LocalDateTime dateTime;

	@Column
	private Integer quantity;

	@Column(name = "amount_paid")
	private float amountPaid;

	@OneToOne
	@JoinColumn(name = "product_id")
	private ProductPojo product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public float getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	public ProductPojo getProduct() {
		return product;
	}

	public void setProduct(ProductPojo product) {
		this.product = product;
	}

}
