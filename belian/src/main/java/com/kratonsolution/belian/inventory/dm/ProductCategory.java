/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="product_category")
public class ProductCategory
{
	@Id
	private String id;
	
	@Column(name="code",nullable=false,unique=true)
	private String code;

	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Column(name="note")
	private String note;
	
	@Version
	private Long version;
}
