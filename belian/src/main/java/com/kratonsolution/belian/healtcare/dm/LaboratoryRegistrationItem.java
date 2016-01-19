/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.inventory.dm.Product;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="laboratory_registration_item")
public class LaboratoryRegistrationItem implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product service;
	
	@Column(name="quantity")
	private BigDecimal quantity;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
	
	@ManyToOne
	@JoinColumn(name="fk_laboratory_registration")
	private LaboratoryRegistration registration;
	
	public LaboratoryRegistrationItem(){}
}
