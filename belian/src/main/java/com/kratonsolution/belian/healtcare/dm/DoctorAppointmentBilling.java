/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.sales.dm.Billing;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="doctor_appointment_billing")
public class DoctorAppointmentBilling extends Billing
{	
	@ManyToOne
	@JoinColumn(name="fk_appointment")
	@NotFound(action=NotFoundAction.IGNORE)
	private DoctorAppointment appointment;
	
	@OneToMany(mappedBy="billing",cascade=CascadeType.ALL)
	private Set<DoctorAppointmentBillingItem> items = new HashSet<DoctorAppointmentBillingItem>();
	
	public DoctorAppointmentBilling(){}
}
