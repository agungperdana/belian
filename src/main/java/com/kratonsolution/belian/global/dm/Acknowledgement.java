/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.api.dm.IDValueRef;
import com.kratonsolution.belian.orders.dm.RoleType;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="acknowledgement")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Acknowledgement implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Enumerated(EnumType.STRING)
	@Column(name="approver_status")
	protected ApproverStatus approverStatus = ApproverStatus.SUBMITTED;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	protected RoleType type = RoleType.INITIATOR;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="person_id")),
		@AttributeOverride(name="value",column=@Column(name="person_value"))
	})
	protected IDValueRef person;
	
	@Version
	protected Long version;

	public abstract Date getDate();
	
	public abstract String getOrigin();
	
	public abstract String getResponding();
	
	public abstract Set<? extends AcknowledgementItem> getDetails();
}
