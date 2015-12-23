/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.PartyRelationship;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * 
 * Doctor to Patient relationship
 */
@Entity
@Table(name="biomedical")
public class Biomedical extends PartyRelationship
{
}
