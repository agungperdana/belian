/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.inventory.dm.Product;
import com.kratonsolution.belian.sales.dm.BillableItem;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="medication_item")
public class MedicationItem implements BillableItem
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_product_medicine")
	private Product medicine;
	
	@Column(name="quantity")
	private BigDecimal quantity = BigDecimal.ONE;
	
	@Column(name="price")
	private BigDecimal price = BigDecimal.ZERO;
	
	@Column(name="discount")
	private BigDecimal discount = BigDecimal.ZERO;
	
	@Column(name="charge")
	private BigDecimal charge = BigDecimal.ZERO;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_medication")
	private Medication medication;
	
	@Version
	private Long version;
	
	public MedicationItem(){}

	@Override
	public String getResource()
	{
		return medicine.getName();
	}

	@Override
	public BigDecimal getUnitPrice()
	{
		return price.subtract(discount).add(charge);
	}

	@Override
	public String getCategory()
	{
		return "Medicine";
	}

	@Override
	public String getMeasure()
	{
		return getMedicine().getUom().getName();
	}
}
