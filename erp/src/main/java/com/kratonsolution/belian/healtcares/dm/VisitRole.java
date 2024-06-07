
package com.kratonsolution.belian.healtcares.dm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.orm.IDValueRef;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="visit_role")
public class VisitRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private VisitRoleType type = VisitRoleType.FRON_OFFICER;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="party_id")),
		@AttributeOverride(name="value",column=@Column(name="party_value"))
	})
	private IDValueRef party;
	
	@ManyToOne
	@JoinColumn(name="fk_visit")
	private Visit visit;
	
	@Version
	private Long version;
	
	public VisitRole(){}
}
