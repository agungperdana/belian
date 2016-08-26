/**
 * 
 */
package com.kratonsolution.belian.procurement.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.accounting.dm.Tax;
import com.kratonsolution.belian.global.dm.ApproveAndReviewable;
import com.kratonsolution.belian.global.dm.Listable;
import com.kratonsolution.belian.global.dm.Review;
import com.kratonsolution.belian.global.dm.Statuses;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="purchase_order_request")
public class PurchaseOrderRequest extends ApproveAndReviewable implements Listable
{
	public static final String NCODE = "POR";
		
	@ManyToOne
	@JoinColumn(name="fk_tax")
	private Tax tax;
	
	@Column(name="date")
	private Date date;
		
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PurchaseOrderRequestItem> items = new HashSet<PurchaseOrderRequestItem>();
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PORStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PORRole> roles = new HashSet<>();
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<PORReview> reviews = new HashSet<>();
	
	public PurchaseOrderRequest(){}
	
	@Override
	public String getLabel()
	{
		return getNumber();
	}

	@Override
	public String getValue()
	{
		return getId();
	}

	@Override
	public String getName()
	{
		return "PO Request";
	}

	@Override
	public Statuses createStatus()
	{
		PORStatus status = new PORStatus();
		status.setRequest(this);
		this.getStatuses().add(status);
		
		return status;
	}

	@Override
	public Review createReview()
	{
		PORReview review = new PORReview();
		review.setRequest(this);
		this.getReviews().add(review);
		return review;
	}
	
	public boolean isCompleted()
	{
		for(PurchaseOrderRequestItem item:items)
		{
			if(item.isOpen())
				return false;
		}
		
		return true;
	}
	
	public BigDecimal getEstimatedCost()
	{
		BigDecimal estimated = BigDecimal.ZERO;
		
		for(PurchaseOrderRequestItem item:getItems())  
			estimated = estimated.add(item.getQuantity().multiply(item.getEstimatedPrice()==null?BigDecimal.ZERO:item.getEstimatedPrice()));
		
		return estimated;
	}
}
