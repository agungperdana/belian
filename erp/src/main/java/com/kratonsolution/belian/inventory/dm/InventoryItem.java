
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.persistence.IDValueRef;
import com.kratonsolution.belian.common.persistence.AuditLog;
import com.kratonsolution.belian.common.persistence.Logable;

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
@Table(name="inventory_item")
public class InventoryItem implements Logable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="expired_date")
	private Date expiredDate;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="product_id")),
		@AttributeOverride(name="value",column=@Column(name="product_value"))
	})
	private IDValueRef product;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="facility_id")),
		@AttributeOverride(name="value",column=@Column(name="facility_value"))
	})
	private IDValueRef facility;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="container_id")),
		@AttributeOverride(name="value",column=@Column(name="container_value"))
	})
	private IDValueRef container;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="on_hand")
	private BigDecimal onhand = BigDecimal.ZERO;
	
	@Column(name="on_order")
	private BigDecimal onorder = BigDecimal.ZERO;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="organization_id")),
		@AttributeOverride(name="value",column=@Column(name="organization_value"))
	})
	private IDValueRef organization;
	
	@Embedded
	private AuditLog log;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="item",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<StockHistory> historys = new HashSet<>();
	
	public InventoryItem()
	{
		setOrganization(new IDValueRef());
		setContainer(new IDValueRef());
		setLog(new AuditLog());
	}
}
