/**
 * 
 */
package com.kratonsolution.belian.tools.dm;

import java.io.Serializable;
import java.sql.Date;
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

import com.kratonsolution.belian.partys.dm.Person;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="inbox")
public class Inbox implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="title")
	private String title;
	
	@Column(name="is_open")
	private boolean open;
	
	@ManyToOne
	@JoinColumn(name="fk_sender")
	private Person sender;
	
	@ManyToOne
	@JoinColumn(name="fk_receiver")
	private Person receiver;
	
	@Column(name="content")
	private String content;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private InboxType type = InboxType.Standard;
	
	@Version
	private Long version;
	
	public Inbox(){}
}