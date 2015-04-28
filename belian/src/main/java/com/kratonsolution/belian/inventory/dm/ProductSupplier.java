/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.EconomicAgent;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="product_supplier")
public class ProductSupplier
{
	@Id
	private String id;

	@Column(name="from_date")
	private Date from;
	
	@Column(name="to_date")
	private Date to;
	
	@ManyToOne
	@JoinColumn(name="fk_party_supplier")
	private EconomicAgent supplier;

	@Column(name="note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="fk_product")
	private Product product;
	
	@Version
	private Long version;
}
