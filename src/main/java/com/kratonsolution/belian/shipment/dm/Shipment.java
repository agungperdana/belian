
package com.kratonsolution.belian.shipment.dm;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;
import com.kratonsolution.belian.orders.dm.OrderType;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="shipment")
public class Shipment implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	private String number;
	
	@Column(name="entry_date")
	private Date entryDate;
	
	@Column(name="estimated_ship_date")
	private Date estShipDate;
	
	@Column(name="estimated_ready_date")
	private Date estReadyDate;
	
	@Column(name="estimated_arrival_date")
	private Date estArrivalDate;
	
	@Column(name="allowable_cancel_date")
	private Date allowableCancelDate;
	
	@Column(name="estimated_ship_cost")
	private BigDecimal estShipCost;
	
	@Column(name="act_ship_cost")
	private BigDecimal actShipCost;
	
	@Column(name="last_updated")
	private Date lastUpdated;
	
	@Column(name="instruction")
	private String instruction;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private ShipmentType type = ShipmentType.CUSTOMER_SHIPMENT;
	
	@Enumerated(EnumType.STRING)
	@Column(name="flow")
	private OrderType flow = OrderType.DROPSHIP;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="ship_from_party_id")),
		@AttributeOverride(name="value",column=@Column(name="ship_from_party_value"))
	})
	private IDValueRef shipFromParty;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="ship_from_address_id")),
		@AttributeOverride(name="value",column=@Column(name="ship_from_address_value"))
	})
	private IDValueRef shipFromAddress;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="ship_from_contact_id")),
		@AttributeOverride(name="value",column=@Column(name="ship_from_contact_value"))
	})
	private IDValueRef shipFromContact;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="ship_to_party_id")),
		@AttributeOverride(name="value",column=@Column(name="ship_to_party_value"))
	})
	private IDValueRef shipToParty;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="ship_to_address_id")),
		@AttributeOverride(name="value",column=@Column(name="ship_to_address_value"))
	})
	private IDValueRef shipToAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="ship_to_contact_id")),
		@AttributeOverride(name="value",column=@Column(name="ship_to_contact_value"))
	})
	private IDValueRef shipToContact;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_shipping_document")
	private ShippingDocument document;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="shipment",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentItem> items = new HashSet<>();
	
	@OneToMany(mappedBy="shipment",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date DESC")
	private Set<ShipmentStatus> statuses = new HashSet<>();
	

	@OneToMany(mappedBy="shipment",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<ShipmentRouteSegment> routes = new HashSet<>();
	
	public Shipment(){}
	
	public boolean isEditable()
	{
		for(ShipmentStatus status:getStatuses())
		{
			if(!status.getType().equals(ShipmentStatusType.SCHEDULED))
				return false;
		}
		
		return true;
	}
	
	public boolean isDelivered()
	{
		for(ShipmentStatus status:getStatuses())
		{
			if(status.getType().equals(ShipmentStatusType.DELIVERED))
				return true;
		}
		
		return false;
	}
	
	public boolean isShipped()
	{
		for(ShipmentStatus status:getStatuses())
		{
			if(status.getType().equals(ShipmentStatusType.SHIPPED))
				return true;
		}
		
		return false;
	}
	
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
	
	/**
	 * used for shipment type customer purchase & purchase retur
	 * internal organization able to send invoice after item shipped into customer/supplier
	 * 
	 * @param isShipped
	 */
	public void setShipped(boolean isShipped)
	{
		if(isShipped)
		{
			ShipmentStatus status = new ShipmentStatus();
			status.setDate(new Timestamp(System.currentTimeMillis()));
			status.setShipment(this);
			status.setType(ShipmentStatusType.SHIPPED);
			
			getStatuses().add(status);
		}
		else
		{
			Iterator<ShipmentStatus> iterator = getStatuses().iterator();
			while (iterator.hasNext())
			{
				ShipmentStatus status = (ShipmentStatus) iterator.next();
				if(status.getType().equals(ShipmentStatusType.SHIPPED))
					iterator.remove();
			}
		}
	}
	
	/**
	 * used for shipment for customer retur & purchase order
	 * internal organization will accept invoice from outside party
	 * if item already receipted.
	 * 
	 * @param isdelivered
	 */
	public void setDelivered(boolean isdelivered)
	{
		if(isdelivered)
		{
			ShipmentStatus status = new ShipmentStatus();
			status.setDate(new Timestamp(System.currentTimeMillis()));
			status.setShipment(this);
			status.setType(ShipmentStatusType.DELIVERED);
			
			getStatuses().add(status);
		}
		else
		{
			Iterator<ShipmentStatus> iterator = getStatuses().iterator();
			while (iterator.hasNext())
			{
				ShipmentStatus status = (ShipmentStatus) iterator.next();
				if(status.getType().equals(ShipmentStatusType.DELIVERED))
					iterator.remove();
			}
		}
	}
}
