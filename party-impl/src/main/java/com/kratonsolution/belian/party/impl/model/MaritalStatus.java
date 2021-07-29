package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.util.Date;
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

import com.kratonsolution.belian.party.api.model.MaritalStatusType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Entity
@Table(name="marital_status")
public class MaritalStatus implements Serializable
{
	private static final long serialVersionUID = 3433856008412192489L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Date start;

	@Setter
	@Column(name="end")
	private Date end;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private MaritalStatusType type = MaritalStatusType.SINGLE;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private Party party;
	
	@Version
	private Long version;
	
	MaritalStatus(){}
	
	public MaritalStatus(@NonNull Party parent, @NonNull Date start, @NonNull MaritalStatusType type) {
		
		this.party = parent;
		this.start = start;
		this.type = type;
	}
}
