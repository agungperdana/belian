/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="organization")
public class Organization extends Party
{
	public enum IndustryType{FOOD,TRAVEL,HOTEL,GOVERMENT,BANKING,FINANCIAL,CHEMICAL,MANUFACTURE,EDUCATION,RETAIL,GENERAL}
	
	@Field("industry_type")
	private IndustryType type = IndustryType.GENERAL;
}
