package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="citizenship")
public class Citizenship implements Serializable
{
	private static final long serialVersionUID = 5343761111880173663L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Instant start;
	
	@Column(name="end")
	private Instant end;
	
	@Column(name="nopassport_number")
	private String passport;

	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;
	
	@Version
	private Long version;
	
	public Citizenship(){}
}