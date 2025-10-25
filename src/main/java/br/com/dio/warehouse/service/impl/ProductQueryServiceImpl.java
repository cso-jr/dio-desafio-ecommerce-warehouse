package br.com.dio.warehouse.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.dio.warehouse.entity.ProductEntity;
import br.com.dio.warehouse.repository.ProductRepository;
import br.com.dio.warehouse.service.IProductQueryService;

@Service
public class ProductQueryServiceImpl implements IProductQueryService{

	private ProductRepository repository;
	

	@Override
	public ProductEntity findById(UUID id) {
		return repository.findById(id).orElseThrow();
	
	}


}
