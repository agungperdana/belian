/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * DISBURSEMENT represents outgoing payments of moneys sent by an internal organization of the enterprise
 */
@Getter
@Setter
@Entity
@Table(name="disbursement")
public class Disbursement extends Payment
{

}