/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;

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
@Table(name="product_category")
public class ProductCategory implements Serializable,Listable
{
	@Id
	private String id;
	
	@Column(name="code",nullable=false,unique=true)
	private String code;

	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Column(name="deleteable")
	private boolean deleteable = true;
	
	@Version
	private Long version;

	@Override
	public String getLabel()
	{
		return getName();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
