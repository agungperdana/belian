/**
 * 
 */
package com.kratonsolution.belian.tools.dm;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="message")
public class Message implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="fk_sender")
	private Person sender;
	
	@Column(name="content")
	private String content;
	
	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private MessageType type = MessageType.Draft;
	
	@Version
	private Long version;

	@OneToMany(mappedBy="message",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<MessageReceiver> receivers = new HashSet<>();
	
	public Message(){}
}