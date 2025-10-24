package br.com.dio.warehouse.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.com.dio.warehouse.dto.ProductStorefrontSaveDTO;
import br.com.dio.warehouse.entity.ProductEntity;
import br.com.dio.warehouse.mapper.IProductMapper;
import br.com.dio.warehouse.repository.ProductRepository;
import br.com.dio.warehouse.service.IProductService;
import br.com.dio.warehouse.service.IStockService;

@Service
public class ProductServiceImpl implements IProductService{

	private final ProductRepository repository = null;
	private final IStockService stockService = null;
	private final RestClient storefrontClient = null;
	private final IProductMapper mapper = null;
	
	
	
	@Override
	public ProductEntity save(ProductEntity entity) {
		repository.save(entity);
		var dto = mapper.toDTO(entity);
		saveStorefront(dto);
		
		return entity;
	}



	@Override
	public ProductEntity findById(UUID id) {
		return repository.findById(id).orElseThrow();
	
	}

	@Override
	public void purchase(UUID id) {
		var entity = findById(id);
		var stock = entity.decStock();
		repository.save(entity);
		if(stock.isUnavailable()) {
			stockService.changeStatus(entity.getId(), stock.getStatus());
		}
	}
	
	private void saveStorefront(ProductStorefrontSaveDTO dto) {
		storefrontClient.post()
		.uri("/products")
		.body(dto)
		.retrieve()
		.body(ProductStorefrontSaveDTO.class);
		
	}

}
