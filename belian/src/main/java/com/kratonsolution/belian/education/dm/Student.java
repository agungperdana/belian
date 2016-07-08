/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="student")
public class Student extends PartyRole
{
	@Column(name="parent_name")
	private String parentName;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Enumerated(EnumType.STRING)
	@Column(name="source")
	private InfoSource source = InfoSource.Friend;
	
	public Student(){}
}
