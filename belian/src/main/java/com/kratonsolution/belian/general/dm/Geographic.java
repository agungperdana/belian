/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="geographic")
public class Geographic 
{
	public enum Type{COUNTRY,CITY,PROVINCE,KECAMATAN,KELURAHAN,RW,RT}

	@Id
	private String id;

	@Column(name="code",unique=true,nullable=false)
	private String code;
	
	@Column(name="name",unique=true,nullable=false)
	private String name;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private Type type = Type.COUNTRY;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
}
