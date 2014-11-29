/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
	
	private String productId;
}
