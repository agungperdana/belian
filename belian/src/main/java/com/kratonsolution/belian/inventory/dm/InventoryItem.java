/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Document(collection="inventory_item")
public class InventoryItem
{
	@Id
	private String id;
	
	@Field("product_id")
	private String productId;
	
	@Field("product_name")
	private String productName;
	
	@Field("facility_id")
	private String facilityId;
	
	@Field("facility_name")
	private String facilityName;
	
	@Field("container_id")
	private String containerId;
	
	@Field("container_name")
	private String containerName;
	
	@Field("serial_number")
	private String serialNumber;
	
	@Field("on_hand")
	private BigDecimal onhand = BigDecimal.ZERO;
}
