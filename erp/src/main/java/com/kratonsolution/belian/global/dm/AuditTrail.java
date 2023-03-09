
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="audit_trail")
public class AuditTrail implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Timestamp date;
	
	@Column(name="type")
	private AuditType type;

	@Column(name="user")
	private String user;
	
	@Column(name="company")
	private String company;
	
	@Column(name="service")
	private String service;

	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	public AuditTrail(){}
}