/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

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
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="bpjs")
public class BPJS implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="card_number",unique=true)
	private String card;
	
	@Column(name="is_active")
	private boolean active;
	
	@Version
	private Long version;
	
	public BPJS(){}
}
