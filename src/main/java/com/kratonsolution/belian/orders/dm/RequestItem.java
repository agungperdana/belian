
package com.kratonsolution.belian.orders.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.global.dm.AcknowledgementItem;
import com.kratonsolution.belian.ui.util.Numbers;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="request_item")
public class RequestItem implements AcknowledgementItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="required_date")
	private Date requiredDate;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;

	@Column(name="max_allowable_price")
	private BigDecimal maxAllowablePrice = BigDecimal.ZERO;

	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="fk_request")
	private Request request;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="product_id")),
		@AttributeOverride(name="value",column=@Column(name="product_value"))
	})
	private IDValueRef product;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RequirementRequest> requiremets = new HashSet<>();

	@Override
	public String getItemDescription()
	{
		return product!=null?product.getValue():description;
	}

	@Override
	public String getOrderQuan()
	{
		return Numbers.format(quantity);
	}

	@Override
	public String getMaxPrice()
	{
		return Numbers.format(maxAllowablePrice);
	}
}
