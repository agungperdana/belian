/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="non_financial_event")
public abstract class NonMonetaryEvent extends EconomicEvent
{
}
