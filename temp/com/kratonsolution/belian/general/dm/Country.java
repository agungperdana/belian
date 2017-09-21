/**
 * 
 */
package com.kratonsolution.belian.general.dm;

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
@Table(name="country")
public class Country implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@Version
	private Long version;
	
	public Country(){}
}
