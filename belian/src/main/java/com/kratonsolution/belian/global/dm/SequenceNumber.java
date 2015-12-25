/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="sequence_number")
public class SequenceNumber implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date = new Date(System.currentTimeMillis());

	@Column(name="person_id")
	private String personId;
	
	@Column(name="organization_id")
	private String companyId;
	
	@Column(name="sequence")
	private int sequence = 1;
	
	@Version
	private Long version;
	
	public SequenceNumber(){}
}