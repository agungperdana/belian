/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.global.dm.Listable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cash_purchase_order")
public class CashPurchaseOrder implements Serializable, Listable
{
	public static final String NCODE = "CSPO";
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="number")
	private String number;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private EconomicAgent supplier;
	
	@ManyToOne
	@JoinColumn(name="fk_purchaser")
	private Person purchaser;

	@ManyToOne
	@JoinColumn(name="fk_purchaser_order_request")
	private PurchaseOrderRequest request;
	
	@Version
	private Long version;
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.global.dm.Listable#getLabel()
	 */
	@Override
	public String getLabel()
	{
		return getNumber();
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.global.dm.Listable#getValue()
	 */
	@Override
	public String getValue()
	{
		return getId();
	}
}
