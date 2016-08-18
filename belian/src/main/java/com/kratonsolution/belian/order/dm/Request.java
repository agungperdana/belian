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
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Party;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="request")
public class Request implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="entry_date")
	private Date entryDate;
	
	@Column(name="required_date")
	private Date requiredDate;
	
	@Column(name="send_date")
	private Date sendDate;
	
	@Column(name="description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private RequestType type = RequestType.Information;

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
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RequestRole> roles = new HashSet<>();
	
	public Request(){}
}
