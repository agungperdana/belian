/**
 * 
 */
package com.kratonsolution.belian.facility.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.kratonsolution.belian.partys.dm.Organization;

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
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	@NotFound(action=NotFoundAction.IGNORE)
	private Organization organization;
	
	@Version
	private Long version;
	
	public FacilityOrganization(){}
}
