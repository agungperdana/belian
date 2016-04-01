/**
 * 
 */
package com.kratonsolution.belian.asset.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Organization;
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
@Table(name="asset")
public class Asset implements Serializable,Listable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code",unique=true)
	private String code;
	
	@Column(name="name",unique=true)
	private String name;
	
	@Column(name="acquired_date")
	private Date acquired;
	
	@Column(name="last_serviced_date")
	private Date lastServiced;
	
	@Column(name="next_serviced_date")
	private Date nextServiced;
	
	@Column(name="buying_price")
	private BigDecimal price = BigDecimal.ZERO;
	
	@Column(name="is_active")
	private boolean active;
	
	@Column(name="is_disposed")
	private boolean disposed;
	
	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_asset_type")
	private AssetType type;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@Version
	private Long version;
	
	public Asset(){}

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
