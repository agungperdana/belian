
package com.kratonsolution.belian.requirement.dm;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

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
