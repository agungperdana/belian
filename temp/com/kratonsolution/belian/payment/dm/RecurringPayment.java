/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="recurring_payment")
public class RecurringPayment extends Disbursement
{
	@Autowired
	private String name;
}
