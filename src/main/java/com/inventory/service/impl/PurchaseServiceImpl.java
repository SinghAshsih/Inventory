package com.inventory.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.PurchasePojo;
import com.inventory.repository.PurchaseRepo;
import com.inventory.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	@Autowired
	PurchaseRepo purchaseRepo;

	@Override
	public PurchasePojo save(PurchasePojo purchase) {
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

		return purchaseRepo.save(purchase);
	}

	@Override
	public void delete(Long id) {
		purchaseRepo.deleteById(id);

	}

}
