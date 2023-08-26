package com.inventory.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class ProductPojo {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column
//	@ManyToOne
//	@JoinColumn(name="item")
	private Long id;

	@Column(name = "name")
	private String productName;

	@Column(name = "price")
	private double cost;

	@Column(name = "quantity")
	private int quantity;

	@Column
	private String description;

	// Many item has one category
//	@ManyToOne
//	@JoinColumn(name = "category_id")
//	private CategoryPojo category;
//
//	@ManyToOne
//	@JoinColumn(name = "supplier_id")
//	private SupplierPojo supplier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public CategoryPojo getCategory() {
//		return category;
//	}
//
//	public void setCategory(CategoryPojo category) {
//		this.category = category;
//	}
//
//	public SupplierPojo getSupplier() {
//		return supplier;
//	}
//
//	public void setSupplier(SupplierPojo supplier) {
//		this.supplier = supplier;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductPojo other = (ProductPojo) obj;
		return Objects.equals(id, other.id);
	}

//	@Override
//	public String toString() {
//		return "ProductPojo [id=" + id + ", productName=" + productName + ", cost=" + cost + ", quantity=" + quantity
//				+ ", description=" + description + ", category=" + category + ", supplier=" + supplier + "]";
//	}
}
