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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Organization;
import com.kratonsolution.belian.global.dm.Status;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="product_receivable")
@Inheritance(strategy=InheritanceType.JOINED)
public class Receivable implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="source")
	private String source;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status = Status.NEW;
	
	@ManyToOne
	@JoinColumn(name="fk_facility")
	private Facility facility;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="receivable",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ReceiveableItem> items = new HashSet<>();
	
	public Receivable(){}
}
