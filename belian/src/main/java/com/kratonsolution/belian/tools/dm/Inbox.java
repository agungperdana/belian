/**
 * 
 */
package com.kratonsolution.belian.tools.dm;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

import com.kratonsolution.belian.general.dm.Person;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="inbox")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Inbox implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	protected Date date;
	
	@Column(name="is_new")
	protected boolean isNew = true;

	@Column(name="opened")
	protected boolean opened = false;
	
	@ManyToOne
	@JoinColumn(name="fk_person_owner")
	protected Person owner;

	
	
	@Column(name="content")
	protected String content;
	
	@Version
	protected Long version;
}