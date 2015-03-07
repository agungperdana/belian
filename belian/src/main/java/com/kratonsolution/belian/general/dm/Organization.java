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

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="organization")
public class Organization extends Party
{
	public enum IndustryType{FOOD,TRAVEL,HOTEL,GOVERMENT,BANKING,FINANCIAL,CHEMICAL,MANUFACTURE,EDUCATION,RETAIL,GENERAL}
	
	@Column(name="industry_type")
	@Enumerated(EnumType.STRING)
	private IndustryType type = IndustryType.GENERAL;
}
