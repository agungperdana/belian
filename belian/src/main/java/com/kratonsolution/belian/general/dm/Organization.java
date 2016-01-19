/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicAgent;

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
}
