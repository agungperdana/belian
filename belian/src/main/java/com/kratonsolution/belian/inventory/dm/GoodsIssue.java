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

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.general.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="goods_issue")
public class GoodsIssue implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_facility_source")
	private Facility source;
	
	@ManyToOne
	@JoinColumn(name="fk_transfer_request")
	private TransferOrderRequest request;
	
	@ManyToOne
	@JoinColumn(name="fk_person_issued_by")
	private Person issuedBy;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<GoodsIssueItem> items = new HashSet<GoodsIssueItem>();
	
	public GoodsIssue(){}
}
