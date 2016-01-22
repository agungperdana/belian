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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.sales.dm.Billable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="laboratory_billing")
public class LaboratoryBilling extends Billable
{
	public enum Status{REGISTERED,HANDLED,FINISHED}
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status = Status.REGISTERED;
	
	@ManyToOne
	@JoinColumn(name="fk_appointment")
	@NotFound(action=NotFoundAction.IGNORE)
	private DoctorAppointment appointment;
	
	@OneToMany(mappedBy="billing",cascade=CascadeType.ALL)
	private Set<LaboratoryBillingItem> items = new HashSet<LaboratoryBillingItem>();
	
	@Override
	public String getBillingType()
	{
		return "Laboratory";
	}
}
