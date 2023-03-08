/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.partys.dm.PartyRelationship;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="employment")
public class Employment extends PartyRelationship
{
}
