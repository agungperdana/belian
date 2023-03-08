
package com.kratonsolution.belian.workefforts.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="production_info")
public class ProductionInfo implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="product_id")),
		@AttributeOverride(name="value",column=@Column(name="product_value"))
	})
	private IDValueRef product;
	
	@Version
	private Long version;
	
	public ProductionInfo(){}
}
