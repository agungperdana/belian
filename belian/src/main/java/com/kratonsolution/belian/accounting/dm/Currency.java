/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.Listable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="currency")
public class Currency implements Serializable,Listable
{
	@Id
	private String id;
	
	@Column(name="code",nullable=false,unique=true)
	private String code;
	
	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Version
	private Long version;

	@Override
	public String getLabel()
	{
		return this.code;
	}

	@Override
	public String getValue()
	{
		return this.id;
	}
}
