/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.sql.Time;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.kratonsolution.belian.sales.dm.Billable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="medical_sales")
public abstract class MedicalSales extends Billable
{
	@Column(name="queue")
	protected int queue = 1;
	
	@Column(name="time")
	protected Time time;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	protected MedicalSalesStatus status = MedicalSalesStatus.Registered;

	public MedicalSales(){}
	
	@Override
	public int getTableNumber()
	{
		return 1;
	}

	public abstract Set<? extends MedicalSalesItem> getItems();
}
