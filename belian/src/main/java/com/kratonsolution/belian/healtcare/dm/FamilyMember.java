/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Entity
@Table(name="family_member")
public class FamilyMember implements Serializable
{
	public enum Type{FATHER,MOTHER,HUSBAND,WIFE,CHILD,BRODTHER,SISTER}
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_patient")
	@NotFound(action=NotFoundAction.IGNORE)
	private Patient patient;
	
	@Enumerated(EnumType.STRING)
	@Column(name="member_type")
	private Type type = Type.HUSBAND;
	
	@ManyToOne
	@JoinColumn(name="fk_folder")
	@NotFound(action=NotFoundAction.IGNORE)
	private FamiliFolder folder;
	
	@Version
	private Long version;

	public FamilyMember(){}
}
