/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.PartyRole;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="carrier")
public class Carrier extends PartyRole
{

}
