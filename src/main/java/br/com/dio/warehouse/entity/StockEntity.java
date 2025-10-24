package br.com.dio.warehouse.entity;

import static jakarta.persistence.EnumType.STRING;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringExclude;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class StockEntity {

	@Id
	private UUID id;
	
	private Long amount;
	
	
	private BigDecimal boughtPrice;
	
	@Enumerated(STRING)
	private StockStatus status;
	
	private BigDecimal soldPrice;
	
	
	public void decAmount(){
		this.amount -= 1;
		if(this.amount == 0) {
			this.status = StockStatus.UNAVAILABLE;
		}
	}
	
	@ToStringExclude
	@ManyToOne
	@JoinColumn(name= "product_id", nullable = false)
	private ProductEntity product;
	
	@PrePersist
	private void prepPersist() {
		this.id = UUID.randomUUID();
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, boughtPrice, id, soldPrice, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockEntity other = (StockEntity) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(boughtPrice, other.boughtPrice)
				&& Objects.equals(id, other.id) && Objects.equals(soldPrice, other.soldPrice) && status == other.status;
	}
	
	
	
}
