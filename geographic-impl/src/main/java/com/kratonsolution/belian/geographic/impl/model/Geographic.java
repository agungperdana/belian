package com.kratonsolution.belian.geographic.impl.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.kratonsolution.belian.common.jpa.model.Auditable;
import com.kratonsolution.belian.geographic.api.GeographicType;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Entity
@Table(name = "geographic")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Geographic extends Auditable implements Serializable {

	private static final long serialVersionUID = 1563365837125974774L;

	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name = "code")
	private String code;

	@Setter
	@Column(name = "name")
	private String name;

	@Setter
	@Column(name = "note")
	private String note;

	@Setter
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private GeographicType type;

	@ManyToOne
	@JoinColumn(name = "fk_parent")
	private Geographic parent;

	@Version
	private Long version;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Geographic> childs = new HashSet<>();

	Geographic(){

	}

	public Geographic(@NonNull String code, @NonNull String name, @NonNull GeographicType type) {

		this.code = code;
		this.name = name;
		this.type = type;
	}

	public Geographic(@NonNull Geographic parent ,@NonNull String code, @NonNull String name, @NonNull GeographicType type) {

		this(code, name, type);
		this.parent = parent;
	}
}
