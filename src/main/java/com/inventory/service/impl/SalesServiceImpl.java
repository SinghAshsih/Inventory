package com.inventory.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.entity.ProductPojo;
import com.inventory.entity.SalesPojo;
import com.inventory.repository.ProductRepo;
import com.inventory.repository.SalesRepo;
import com.inventory.service.SalesService;

@Service
public class SalesServiceImpl implements SalesService {
	@Autowired
	SalesRepo salesRepo;
	@Autowired
	ProductRepo productRepo;

	@Override
	public SalesPojo save(SalesPojo sales) {
		Long proId = sales.getProduct().getId();
		Optional<ProductPojo> opt = productRepo.findById(proId);
		ProductPojo obj = opt.get();

		Integer q1 = obj.getQuantity();
		Integer q2 = sales.getQuantity();
		Integer sub = q1 - q2;
		obj.setQuantity(sub);
		productRepo.save(obj);
		sales.setDateTime(LocalDateTime.now());
		return salesRepo.save(sales);
	}

	@Override
	public Iterable<SalesPojo> findAll() {
		return salesRepo.findAll();
	}

	@Override
	public SalesPojo update(SalesPojo sales) {
		return salesRepo.save(sales);
	}

	@Override
	public void delete(Long id) {
		salesRepo.deleteById(id);

	}

	@Override
	public SalesPojo findById(Long id) {
		Optional<SalesPojo> getBYId = salesRepo.findById(id);
		return getBYId.get();
	}

}
