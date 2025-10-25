package br.com.dio.warehouse.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.warehouse.controller.request.StockSaveRequest;
import br.com.dio.warehouse.controller.response.StockSavedResponse;
import br.com.dio.warehouse.mapper.IStockMapper;
import br.com.dio.warehouse.service.IStockService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("stocks")
@AllArgsConstructor
public class StockController {

	private final IStockService service;
	private final IStockMapper mapper;
		
	@PostMapping
	@ResponseStatus(CREATED)
	StockSavedResponse save(@RequestBody final StockSaveRequest request) {
		var entity = mapper.toEntity(request);
		entity = service.save(entity);
		return mapper.toResponse(entity);
	}
	
	@PutMapping("{id}/active")
	@ResponseStatus(NO_CONTENT)
	void active(@PathVariable final UUID id) {
		service.release(id);
	}
	

	@DeleteMapping("{id}/release")
	@ResponseStatus(NO_CONTENT)
	void inactive(@PathVariable final UUID id) {
		service.inactive(id);
	}
	
}
