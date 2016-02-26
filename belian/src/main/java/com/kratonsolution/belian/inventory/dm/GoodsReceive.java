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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.global.dm.ProductReceiveable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="goods_receive")
public class GoodsReceive implements Serializable
{
	public static final String NCODE = "GRV";
	
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
	@JoinColumn(name="fk_facility_destination")
	private Facility destination;
	
	@ManyToOne
	@JoinColumn(name="fk_receiveable")
	private ProductReceiveable reference;
	
	@ManyToOne
	@JoinColumn(name="fk_person_received_by")
	private Person receiver;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="goodsReceive",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<GoodsReceiveItem> items = new HashSet<GoodsReceiveItem>();
	
	public GoodsReceive(){}
}
