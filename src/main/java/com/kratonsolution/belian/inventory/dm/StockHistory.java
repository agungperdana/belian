/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.common.dm.AuditLog;
import com.kratonsolution.belian.common.dm.Logable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="stock_history")
public class StockHistory implements Logable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="stock_in")
	private BigDecimal in;
	
	@Column(name="stock_out")
	private BigDecimal out;
	
	@Embedded
	private AuditLog log = new AuditLog();
	
	@ManyToOne
	@JoinColumn(name="fk_inventory_item")
	private InventoryItem item;
	
	@Version
	private Long version;

	public StockHistory(){}
}
