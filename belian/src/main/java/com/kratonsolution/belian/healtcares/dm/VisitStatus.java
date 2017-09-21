/**
 * 
 */
package com.kratonsolution.belian.healtcares.dm;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="visit_status")
public class VisitStatus implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Timestamp date;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private VisitStatusType type = VisitStatusType.SCHEDULED;
	
	@ManyToOne
	@JoinColumn(name="fk_visit")
	private Visit visit;
	
	@Version
	private Long version;
	
	public VisitStatus(){}
}
