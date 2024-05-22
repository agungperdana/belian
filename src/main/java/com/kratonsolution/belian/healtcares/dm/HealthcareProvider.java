
package com.kratonsolution.belian.healtcares.dm;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import com.kratonsolution.belian.partys.dm.PartyRole;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="healthcare_provider")
public class HealthcareProvider extends PartyRole
{

}