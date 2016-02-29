/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicAgent;
import com.kratonsolution.belian.inventory.dm.FacilityOrganization;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="organization")
public class Organization extends EconomicAgent
{
	@Column(name="industry_type")
	@Enumerated(EnumType.STRING)
	private IndustrySegmentation type = IndustrySegmentation.GENERAL;
	
	@OneToMany(mappedBy="organization",fetch=FetchType.EAGER)
	private Set<FacilityOrganization> facilitys = new HashSet<>();
	
	@OneToMany(mappedBy="from",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<OrganizationRole> roles = new HashSet<>();
}
