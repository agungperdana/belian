/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.facility.dm.FacilityOrganization;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="organization")
@Cacheable
public class Organization extends Party
{
	@Column(name="industry_type")
	@Enumerated(EnumType.STRING)
	private IndustrySegmentation type = IndustrySegmentation.GENERAL;
	
	@OneToMany(mappedBy="organization",fetch=FetchType.EAGER)
	private Set<FacilityOrganization> facilitys = new HashSet<>();
}
