/**
 * 
 */
package com.kratonsolution.belian.requirement.dm;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
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
@Table(name="deliverable")
public class Deliverable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name")
	private String name;
	
	@Column(name="note")
	private String note;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private DeliverableType type = DeliverableType.PROJECT;

	@Version
	private Long version;

	public Deliverable(){}
}
