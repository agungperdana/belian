
package com.kratonsolution.belian.products.dm;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;

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
@Table(name="product_supplier")
public class ProductSupplier implements Serializable
{
	@Id
	private String id = "0";

	@Column(name="start")
	private Date start;
	
	@Column(name="end")
	private Date end;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="supplier_id")),
		@AttributeOverride(name="value",column=@Column(name="supplier_value"))
	})
	private IDValueRef supplier;

	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Version
	private Long version;
	
	public ProductSupplier(){}
}
