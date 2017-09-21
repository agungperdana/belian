/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
@Table(name="facility_organization")
public class FacilityOrganization implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="enabled")
	private boolean enabled;
	
	@ManyToOne
	@JoinColumn(name="fk_facility")
	@NotFound(action=NotFoundAction.IGNORE)
	private Facility facility;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="organization_id")),
		@AttributeOverride(name="value",column=@Column(name="organization_value"))
	})
	protected IDValueRef organization;
	
	@Version
	private Long version;
	
	public FacilityOrganization(){}
}
