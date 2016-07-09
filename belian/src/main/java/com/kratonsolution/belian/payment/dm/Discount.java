/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.Listable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="discount")
public class Discount implements Listable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="name")
	private String name;
	
	@Column(name="value")
	private BigDecimal amount;

	@Column(name="is_percent")
	private boolean percent;
	
	@Version
	private Long version;

	public Discount(){}

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
