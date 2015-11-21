/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

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
@Table(name="user_setting")
public class UserSetting implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="organization_id")
	private String organizationId;
	
	@Column(name="organization_name")
	private String organizationName;
	
	@Column(name="location_id")
	private String locationId;
	
	@Column(name="location_name")
	private String locationName;
	
	@Column(name="currency_id")
	private String currencyId;

	@Column(name="currency_name")
	private String currencyName;
	
	@Column(name="language")
	private String language;
	
	@Column(name="row_per_page")
	private int rowPerPage = 25;
	
	@Version
	private Long version;
}
