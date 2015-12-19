/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.inventory.dm.Product;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="treatment")
public class Treatment
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_product_treatment")
	private Product service;
	
	@Column(name="quantity")
	private BigDecimal quantity;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="fk_medical_record")
	private MedicalRecord medical;
	
	@Version
	private Long version;
	
	public Treatment(){}
}
