/**
 * 
 */
package com.kratonsolution.belian.payment.dm;

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
@Table(name="deduction_type")
public class DeductionType implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name",unique=true)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	public DeductionType(){}
}
