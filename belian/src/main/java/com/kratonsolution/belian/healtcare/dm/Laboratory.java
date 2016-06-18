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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.common.base.Strings;
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
@Table(name="laboratory")
public class Laboratory extends Billable
{
	@Column(name="is_bpjs")
	private boolean bpjs;
	
	@Column(name="is_personal")
	private boolean personal;
	
	@Enumerated(EnumType.STRING)
	@Column(name="bpjs_payment_status")
	private BPJSPaymentStatus bpjsStatus = BPJSPaymentStatus.UNPAID;
	
	@Enumerated(EnumType.STRING)
	@Column(name="lab_handling_status")
	private LabHandlingStatus status = LabHandlingStatus.Registered;
	
	@OneToMany(mappedBy="laboratory",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<LaboratoryItem> items = new HashSet<LaboratoryItem>();

	public Laboratory(){}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.sales.dm.Billable#getBillingType()
	 */
	@Override
	public String getBillingType(String lang)
	{
		if(Strings.isNullOrEmpty(lang) || lang.equals("in_ID"))
			return personal?"Lab Mandiri":"Lab Klinik";
		else
			return personal?"Laboratory":"Clinic Laboratory";
	}

	@Override
	public int getTableNumber()
	{
		return 0;
	}
}
