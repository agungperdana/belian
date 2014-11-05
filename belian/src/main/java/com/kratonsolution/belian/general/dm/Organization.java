/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="organization")
public class Organization extends Party
{
	public static Organization newInstance()
	{
		Organization organization = new Organization();
		organization.setId(UUID.randomUUID().toString());
		return organization;
	}
}
