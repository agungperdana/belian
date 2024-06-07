package com.kratonsolution.belian.core.party.impl.orm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
 * @since 0.0.1
 */
@Getter
@Setter
@Entity
@Table(name="physical_characteristic")
public class PhysicalCharacteristic implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private PhysicalCharacteristicType type = PhysicalCharacteristicType.HEIGHT;
	
	@Column(name="value")
	private String value;
	
	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;
	
	@Version
	private Long version;
	
	public PhysicalCharacteristic(){}
}