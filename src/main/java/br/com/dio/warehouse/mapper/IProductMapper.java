package br.com.dio.warehouse.mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

import org.mapstruct.Mapper;

import br.com.dio.warehouse.dto.ProductStorefrontSaveDTO;
import br.com.dio.warehouse.entity.ProductEntity;

@Mapper(componentModel = SPRING)
public interface IProductMapper {

	ProductStorefrontSaveDTO toDTO(final ProductEntity entity);
	
}
