
package com.kratonsolution.belian.orders.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
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
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.common.orm.IDValueRef;
import com.kratonsolution.belian.global.dm.ApproverStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="request")
public class Request implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="number")
	private String number;
	
	@Column(name="is_closed")
	private boolean closed;
	
	@Column(name="entry_date")
	private Date entryDate;
	
	@Column(name="required_date")
	private Date requiredDate;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="description")
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private RequestType type = RequestType.INFORMATION;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="originator_id")),
		@AttributeOverride(name="value",column=@Column(name="originator_value"))
	})
	private IDValueRef originator;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="id",column=@Column(name="responding_id")),
		@AttributeOverride(name="value",column=@Column(name="responding_value"))
	})
	private IDValueRef responding;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<RequestItem> items = new HashSet<>();
	
	@OneToMany(mappedBy="request",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<RequestRole> roles = new HashSet<>();
	
	public Request(){}
	
	public boolean isEditable()
	{
		for(RequestRole role:getRoles())
		{
			if(role.getApproverStatus().equals(ApproverStatus.ACCEPTED) || role.getApproverStatus().equals(ApproverStatus.REJECTED))
				return false;
		}
		
		return true;
	}
	
	public String getCreator()
	{
		for(RequestRole role:getRoles())
		{
			if(role.getType().equals(RoleType.ENTERED_BY))
				return role.getPerson().getValue();
		}
		
		return "";
	}
	
	public String getApprover()
	{
		for(RequestRole role:getRoles())
		{
			if(role.getType().equals(RoleType.APPROVER))
				return role.getPerson().getValue();
		}
		
		return "";
	}
}
