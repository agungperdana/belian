
package com.kratonsolution.belian.healtcares.dm;

import com.kratonsolution.belian.party.impl.orm.PartyRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="patient")
public class Patient extends PartyRole
{

}
