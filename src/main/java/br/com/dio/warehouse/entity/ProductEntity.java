package br.com.dio.warehouse.entity;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.builder.ToStringExclude;
import static br.com.dio.warehouse.entity.StockStatus.AVALIABLE;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class ProductEntity {

	@Id
	private UUID id;
	
	private String name;
	
	@ToStringExclude
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<StockEntity> stocks = new HashSet<>();
	
	public StockEntity decStock() {
		var stock = this.stocks.stream()
				.filter(s -> s.getStatus().equals(AVALIABLE))
				.min(Comparator.comparing(StockEntity::getSoldPrice))
				.orElseThrow();
		return stock;
	}
	
	@PrePersist
	private void prepPersist() {
		this.id = UUID.randomUUID();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductEntity other = (ProductEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	
	
	
}
