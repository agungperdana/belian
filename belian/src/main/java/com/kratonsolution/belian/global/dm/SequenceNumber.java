/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.common.DateTimes;

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
@Cacheable
public class SequenceNumber implements Serializable
{
	public enum Code{BLDP,BLMED,BLLAB,LABREG,BLTRE,PHS,CLS}
	
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date = DateTimes.currentDate();

	@Column(name="person_id")
	private String personId;
	
	@Column(name="organization_id")
	private String companyId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="code")
	private Code code;
	
	@Column(name="sequence")
	private int sequence = 1;
	
	@Version
	private Long version;
	
	public SequenceNumber(){}
}
