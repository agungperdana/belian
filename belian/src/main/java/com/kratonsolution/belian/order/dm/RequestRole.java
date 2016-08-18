/**
 * 
 */
package com.kratonsolution.belian.order.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="request_role")
public class RequestRole implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_person")
	private Person person;

	@ManyToOne
	@JoinColumn(name="fk_request")
	private Request request;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private RoleType type = RoleType.Initiator;
	
	@Version
	private Long version;
	
	public RequestRole(){}
}
