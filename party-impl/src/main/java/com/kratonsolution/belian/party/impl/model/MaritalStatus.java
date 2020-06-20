package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.kratonsolution.belian.party.api.model.MaritalStatusType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since
 */
@Getter
@Setter
@Entity
@Table(name="marital_status")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MaritalStatus implements Serializable
{
	private static final long serialVersionUID = 3433856008412192489L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Instant start;
	
	@Column(name="end")
	private Instant end;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private MaritalStatusType type = MaritalStatusType.SINGLE;
	
	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;
	
	@Version
	private Long version;
	
	public MaritalStatus(){}
}
