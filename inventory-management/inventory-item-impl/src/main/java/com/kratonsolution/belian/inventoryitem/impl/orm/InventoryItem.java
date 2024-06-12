package com.kratonsolution.belian.inventoryitem.impl.orm;

import com.kratonsolution.belian.common.orm.AuditLog;
import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.common.orm.Logable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
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
