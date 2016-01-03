/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.Listable;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="unit_of_measure")
public class UnitOfMeasure implements Serializable,Listable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code",nullable=false,unique=true)
	private String code;
	
	@Column(name="name",nullable=false,unique=true)
	private String name;

	@Column(name="note")
	private String note;
	
	@Version
	private Long version;

	@Override
	public String getLabel()
	{
		return getCode();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
