
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.app.DateTimes;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="sequence_number")
public class SequenceNumber implements Serializable
{
	/**
	 * Enum for code type
	 */
	public enum Code{
		/**
		 * PO	: Purchase Order
		 */
		PO,
		
		/**
		 * SO	: Sales Order
		 */
		SO,
		
		/**
		 * CSO	: CASH Sales
		 */
		CSO,
		
		/**
		 * DSO	: Drop Ship Sales
		 */
		DSO,
		
		/**
		 * REQ	: Request
		 */
		REQ,
		
		/**
		 * SHP	: Shipment
		 */
		SHP,
		
		/**
		 * SHR	: Shipment Receipt
		 */
		SHR,
		
		/**
		 * SHI	: Shipment Issuance
		 */
		SHI,
		
		/**
		 * WKR	: Work Requirement
		 */
		WRQ,
		
		/**
		 * PRQ	: Product Requirement
		 */
		PRQ,
		
		/**
		 * WEF	: Work Effort
		 */
		WEF,
		
		/**
		 * SIV	: Sales Invoice
		 */
		SIV,
		
		/**
		 * PIV	: Purchase Invoice
		 */
		PIV,
		
		/**
		 * RCT	: Receipt
		 */
		RCT,
		
		/**
		 * DMT	: Disbursement
		 */
		DMT,
		
		/**
		 * VST	: Doctor Visit
		 */
		VST
	}
	
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="date")
	private Date date = DateTimes.currentDate();
	
	@Column(name="organization_id")
	private String companyId;
	
	@Enumerated(EnumType.STRING)
	@Column(name="code")
	private Code code;
	
	@Column(name="sequence")
	private int sequence = 1;
	
	@Version
	private Long version;
	
	public SequenceNumber(){}
	
	public void plus()
	{
		setSequence(getSequence()+1);
	}
}
