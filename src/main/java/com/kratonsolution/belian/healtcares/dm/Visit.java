/**
 * 
 */
package com.kratonsolution.belian.healtcares.dm;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.common.dm.Referenceable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="visit")
public class Visit implements Referenceable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="code",unique=true,nullable=false)
	private String code;
	
	@Column(name="date",nullable=false)
	private Date date;
	
	@Column(name="reason",nullable=false)
	private String reason;
	
	@Column(name="note",nullable=false)
	private String note;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="organization_id")),
		@AttributeOverride(name="value",column=@Column(name="organization_value"))
	})
	private IDValueRef organization;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="doctor_id")),
		@AttributeOverride(name="value",column=@Column(name="doctor_value"))
	})
	private IDValueRef doctor;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="patient_id")),
		@AttributeOverride(name="value",column=@Column(name="patient_value"))
	})
	private IDValueRef patient;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="visit",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<VisitRole> roles = new HashSet<>();
	
	@OneToMany(mappedBy="visit",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date DESC")
	private Set<VisitStatus> statuses = new HashSet<>();
	
	@OneToMany(mappedBy="visit",cascade=CascadeType.ALL,orphanRemoval=true)
	@OrderBy("date ASC")
	private Set<HealthcareDelivery> deliverys = new HashSet<>();

	public Visit(){}
	
	public Visit(IDValueRef ref)
	{
		if(ref != null)
		{
			setId(ref.getId());
			setReason(ref.getValue());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.common.dm.Referenceable#getLabel()
	 */
	@Override
	public String getLabel()
	{
		return getPatient().getValue()+" ("+getReason()+")";
	}

	/* (non-Javadoc)
	 * @see com.kratonsolution.belian.common.dm.Referenceable#getValue()
	 */
	@Override
	public String getValue()
	{
		return getId();
	}
	
	public boolean isEditable()
	{
		for(VisitStatus status:getStatuses())
			if(status.getType().equals(VisitStatusType.CONCLUDED))
				return false;
	
		return true;
	}
	
	public boolean isSignedIn()
	{
		for(VisitStatus status:getStatuses())
			if(status.getType().equals(VisitStatusType.SIGNEDIN))
				return true;
	
		return false;
	}
	
	public boolean isClosed()
	{
		for(VisitStatus status:getStatuses())
			if(status.getType().equals(VisitStatusType.CLOSED))
				return true;
	
		return false;
	}
	
	public Timestamp getLastStatusDate()
	{
		VisitStatus queue = null;
		VisitStatus signedIn = null;
		VisitStatus concluded = null;
		
		for(VisitStatus status:getStatuses())
		{
			if(status.getType().equals(VisitStatusType.SCHEDULED))
				queue = status;
			else if(status.getType().equals(VisitStatusType.SIGNEDIN))
				signedIn = status;
			else if(status.getType().equals(VisitStatusType.CONCLUDED))
				concluded = status;
		}
		
		if(concluded != null)
			return concluded.getDate();
		else if(signedIn != null)
			return signedIn.getDate();
		else if(queue != null)
			return queue.getDate();
		
		return new Timestamp(System.currentTimeMillis());
	}
}
