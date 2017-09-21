/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.Strings;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="medical_treatment_sales")
public class MedicalTreatmentSales extends MedicalSales
{
	@Enumerated(EnumType.STRING)
	@Column(name="bpjs_payment_status")
	private BPJSPaymentStatus bpjsStatus = BPJSPaymentStatus.UNPAID;
	
	@OneToMany(mappedBy="treatment",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<MedicalTreatmentSalesItem> items = new HashSet<MedicalTreatmentSalesItem>(); 
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.sales.dm.Billable#getBillingType()
	 */
	@Override
	public String getBillingType(String lang)
	{
		if(Strings.isNullOrEmpty(lang) || lang.equals("in_ID"))
			return "Periksa";
		else
			return "Clinic Treatment";
	}

	@Override
	public int getTableNumber()
	{
		return 0;
	}

	@Override
	public String getName()
	{
		return "Medical Treatment Sales";
	}
}
