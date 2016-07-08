/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.general.dm.InternalOrganization;
import com.kratonsolution.belian.general.dm.PartyRelationship;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="student_relationship")
public class StudentRelationship extends PartyRelationship
{
	@ManyToOne
	@JoinColumn(name="fk_student")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private InternalOrganization organization;
}
