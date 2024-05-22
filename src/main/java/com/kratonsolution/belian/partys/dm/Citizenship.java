
package com.kratonsolution.belian.partys.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="citizenship")
public class Citizenship implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Column(name="nopassport")
	private String passport;

	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;
	
	@Version
	private Long version;
	
	public Citizenship(){}
}
