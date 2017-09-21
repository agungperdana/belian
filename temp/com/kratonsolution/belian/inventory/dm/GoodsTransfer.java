/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

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

import com.kratonsolution.belian.facility.dm.Facility;
import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.partys.dm.Organization;
import com.kratonsolution.belian.partys.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="goods_transfer")
public class GoodsTransfer implements Serializable, Listable
{
	public static String NCODE = "GST";
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="number")
	private String number;
	
	@ManyToOne
	@JoinColumn(name="fk_organization_source")
	private Organization source;
	
	@ManyToOne
	@JoinColumn(name="fk_organization_destination")
	private Organization destination;
	
	@ManyToOne
	@JoinColumn(name="fk_facility_from")
	private Facility facilityFrom;
	
	@ManyToOne
	@JoinColumn(name="fk_facility_to")
	private Facility facilityTo;

	@ManyToOne
	@JoinColumn(name="fk_transfer_order_request")
	private TransferOrderRequest request;
	
	@ManyToOne
	@JoinColumn(name="fk_person_transfered_by")
	private Person transferedBy;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="goodsTransfer",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<GoodsTransferItem> items = new HashSet<>();
	
	public GoodsTransfer(){}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.global.dm.Listable#getLabel()
	 */
	@Override
	public String getLabel()
	{
		return number;
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.global.dm.Listable#getValue()
	 */
	@Override
	public String getValue()
	{
		return id;
	}
}
