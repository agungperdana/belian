/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.hr.dm.Employee;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * PAYCHECK is a subtype of the DISBURSEMENT entity and is modeled sep- arately 
 * because of some of the unique aspects of a paycheck as opposed to other disbursements
 */
@Getter
@Setter
@Entity
@Table(name="paycheck")
public class Paycheck extends Disbursement
{
	@ManyToOne
	@JoinColumn(name="fk_employee")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name="fk_employer")
	private Organization employer;
	
	@OneToMany(mappedBy="paycheck",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<Deduction> deductions = new HashSet<>();
}
