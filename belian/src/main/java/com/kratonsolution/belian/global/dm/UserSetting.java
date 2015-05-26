/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Geographic;
import com.kratonsolution.belian.general.dm.Organization;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="user_setting")
public class UserSetting implements Serializable
{
	@Id
	private String id;
	
	@ManyToOne
	@JoinColumn(name="fk_organization")
	private Organization organization;
	
	@ManyToOne
	@JoinColumn(name="fk_location")
	private Geographic location;
	
	@Column(name="language")
	private String language;
	
	@Version
	private Long version;
}
