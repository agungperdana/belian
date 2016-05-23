/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="benefit_type")
public class BenefitType implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code",unique=true)
	private String code;
	
	@Column(name="name",unique=true)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	public BenefitType(){}
}
