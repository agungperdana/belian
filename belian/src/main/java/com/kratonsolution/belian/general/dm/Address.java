/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.EconomicAgent;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="address")
public class Address
{
	public enum Type{HOME,OFFICE,WAREHOUSE}
	
	@Id
	private String id;
	
	@Column(name="address",nullable=false)
	private String address;
		
	@Column(name="postal",nullable=false)
	private String postal;
	
	@Column(name="active",nullable=false)
	private boolean active;
	
	@Column(name="type",nullable=false)
	@Enumerated(EnumType.STRING)
	private Type type = Type.OFFICE;

	@ManyToOne
	@JoinColumn(name="fk_geographic_city")
	private Geographic city;
	
	@ManyToOne
	@JoinColumn(name="fk_geographic_province")
	private Geographic province;
	
	@ManyToOne
	@JoinColumn(name="fk_geographic_country")
	private Geographic country;
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	private EconomicAgent party;
	
	@Version
	private Long version;
}
