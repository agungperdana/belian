/**
 * 
 */
package com.kratonsolution.belian.shipment.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.asset.dm.Asset;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="shipment_route_segment")
public class ShipmentRouteSegment implements Serializable
{
	@Column(name="est_start_date")
	private Date estStartDate;
	
	@Column(name="est_arrival_date")
	private Date estArrivalDate;

	@Column(name="act_start_date")
	private Date actStartDate;

	@Column(name="act_arrival_date")
	private Date actArrivalDate;
	
	@Column(name="start_mileage")
	private BigDecimal startMileage = BigDecimal.ZERO;
	
	@Column(name="end_mileage")
	private BigDecimal endMileage = BigDecimal.ZERO;

	@Column(name="fuel_used")
	private BigDecimal fuelUsed = BigDecimal.ZERO;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private ShipmentMethodType type = ShipmentMethodType.Ground;

	@ManyToOne
	@JoinColumn(name="fk_vehicle")
	private Asset vehicle;
	
	@ManyToOne
	@JoinColumn(name="fk_carrier")
	private Carrier carrier;
	
	@ManyToOne
	@JoinColumn(name="fk_shipment")
	private Shipment shipment;
	
	@Version
	private Long version;

	public ShipmentRouteSegment(){}
}
