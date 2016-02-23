/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.global.dm.Approveable;
import com.kratonsolution.belian.global.dm.Listable;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="transfer_order_request")
public class TransferOrderRequest extends Approveable implements Listable
{
	public static final String NCODE = "TRQ";
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<TransferOrderRequestItem> items = new HashSet<>();
	
	@OneToMany(mappedBy="request")
	private Set<GoodsIssue> issues = new HashSet<GoodsIssue>();
	
	public TransferOrderRequest(){}

	@Override
	public String getType()
	{
		return "Transfer Order Request";
	}

	@Override
	public String getLabel()
	{
		if(getNumber() == null || getNumber().equals(""))
			setNumber(NCODE+System.currentTimeMillis());
		
		return getNumber();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
