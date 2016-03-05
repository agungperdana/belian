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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.security.dm.User;

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
	
	@Column(name="is_open")
	private boolean opened;
	
	@Column(name="title")
	private String title;
	
	@Column(name="content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name="fk_user")
	private User sender;
	
	@OneToMany(mappedBy="message",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	private Set<MessageReceiver> receiver = new HashSet<>();
	
	public Message(){}
}
