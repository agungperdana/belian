/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="pick_list")
public class PickList implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="create_date")
	private Date createDate;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="list",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<PickListItem> items = new HashSet<>();
	
	public PickList(){}
}
