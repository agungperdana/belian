/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.global.dm.HasStatus;
import com.kratonsolution.belian.global.dm.Roled;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="purchase_order_request_role")
public class PORRole extends Roled
{
	@ManyToOne
	@JoinColumn(name="fk_purchase_order_request")
	private PurchaseOrderRequest request;

	@Override
	public HasStatus getDocument()
	{
		return getRequest();
	}
}
