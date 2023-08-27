package com.inventory.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.ProductPojo;
import com.inventory.entity.PurchasePojo;
import com.inventory.repository.ProductRepo;
import com.inventory.repository.PurchaseRepo;
import com.inventory.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	PurchaseRepo purchaseRepo;

	@Autowired
	ProductRepo productRepo;

	@Override
	public PurchasePojo save(PurchasePojo purchase) {
		// Integer purchaseQuantity = purchase.getQuantity();
		ProductPojo product = purchase.getProduct();
		Long prodId = product.getId();
		Optional<ProductPojo> productOpt = productRepo.findById(prodId);
		ProductPojo product3 = productOpt.get();
		Integer qq1 = product3.getQuantity();
		Integer qq2 = purchase.getQuantity();
		Integer sum = qq1 + qq2;
		product3.setQuantity(sum);
		productRepo.save(product3);

//		Iterable<ProductPojo> productlist = productRepo.findAll();
//		for (ProductPojo prodcut : productlist) {
//			if (prodcut.getId().equals(purchase.getProduct().getId())) {
//				Integer productQuantity1 = prodcut.getQuantity();
//				int sumQuantity = purchaseQuantity + productQuantity1;
////				prodcut.setQuantity(sumQuantity);
//				productRepo.save(prodcut);
//			}
//
//		}

		purchase.setDate(LocalDateTime.now());
		return purchaseRepo.save(purchase);
	}

	@Override
	public Iterable<PurchasePojo> get() {
		return purchaseRepo.findAll();
	}

	@Override
	public PurchasePojo getById(Long id) {
		Optional<PurchasePojo> data = purchaseRepo.findById(id);
		if (!data.isPresent()) {

		}
		return data.get();
	}

	@Override
	public PurchasePojo update(PurchasePojo purchase) {
		purchase.setDate(LocalDateTime.now());
		return purchaseRepo.save(purchase);
	}

	@Override
	public void delete(Long id) {
		purchaseRepo.deleteById(id);

	}

}
