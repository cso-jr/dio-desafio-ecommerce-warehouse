package br.com.dio.warehouse.dto;

import java.util.UUID;


import br.com.dio.warehouse.entity.StockStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public record StockStatusMessage(

		@JsonProperty("id")
		UUID id,	
		@JsonProperty("status")
		StockStatus status
		) {

}
