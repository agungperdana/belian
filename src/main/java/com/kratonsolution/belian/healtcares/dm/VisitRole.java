/**
 * 
 */
package com.kratonsolution.belian.healtcares.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;

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
