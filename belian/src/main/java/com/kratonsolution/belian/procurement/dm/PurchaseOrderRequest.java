/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.global.dm.HasStatus;
import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.global.dm.Statuses;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="purchase_order_request")
public class PurchaseOrderRequest implements Serializable,Listable,HasStatus
{
	public static final String NCODE = "POR";
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	private String number;
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;

	@ManyToOne
	@JoinColumn(name="fk_last_status")
	private Statuses lastStatus;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PurchaseOrderRequestItem> items = new HashSet<PurchaseOrderRequestItem>();
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PORStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PORRole> roles = new HashSet<>();
	
	public PurchaseOrderRequest(){}
	
	@Override
	public String getLabel()
	{
		return getNumber();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
