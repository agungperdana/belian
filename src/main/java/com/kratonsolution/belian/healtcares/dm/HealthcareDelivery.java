/**
 * 
 */
package com.kratonsolution.belian.healtcares.dm;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="healthcare_delivery")
public class HealthcareDelivery implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date",nullable=false)
	private Timestamp date;
	
	@Column(name="note",nullable=false)
	private String note;
	
	@Column(name="quantity",nullable=false)
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="uom_id")),
		@AttributeOverride(name="value",column=@Column(name="uom_value"))
	})
	private IDValueRef uom;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private HealthcareDeliveryType type = HealthcareDeliveryType.EXAMINATION;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="product_id")),
		@AttributeOverride(name="value",column=@Column(name="product_value"))
	})
	private IDValueRef product;
	
	@ManyToOne
	@JoinColumn(name="fk_visit")
	private Visit visit;
	
	@Version
	private Long version;
	
	public HealthcareDelivery(){}
	
	public HealthcareDelivery(IDValueRef ref)
	{
		if(ref != null)
		{
			setNote(ref.getValue());
			setId(ref.getId());
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.common.dm.Referenceable#getLabel()
	 */
	@Override
	public String getLabel()
	{
		return getNote();
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.common.dm.Referenceable#getValue()
	 */
	@Override
	public String getValue()
	{
		return getId();
	}

}
