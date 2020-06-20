package com.kratonsolution.belian.party.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.common.model.Auditable;
import com.kratonsolution.belian.geographic.impl.model.Geographic;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
@Getter
@Setter
@Entity
@Table(name="organization")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Organization extends Auditable implements Serializable
{
	private static final long serialVersionUID = -8776380253280140352L;
	
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_party")
	@NotFound(action = NotFoundAction.IGNORE)
	private Party party;

	@Version
	private Long version;
	
	Organization(){}
	
	public Organization(@NonNull String code, @NonNull String name, String taxCode, Instant birthDate, Geographic birthPlace) {
		
		this.party = new Party(code, name, taxCode, birthPlace, birthDate);
	}
}
