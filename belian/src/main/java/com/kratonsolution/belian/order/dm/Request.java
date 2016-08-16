/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Party;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public class Request implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="required_date")
	private Date requiredDate;
	
	@Column(name="send_date")
	private Date sendDate;
	
	@Column(name="description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private RequestType type = RequestType.RequestForInformation;

	@ManyToOne
	@JoinColumn(name="fk_originator")
	private Party originator;
	
	@ManyToOne
	@JoinColumn(name="fk_responding")
	private Party responding;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RequestItem> items = new HashSet<>();
	
	public Request(){}
}
