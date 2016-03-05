/**
 * 
 */
package com.kratonsolution.belian.tools.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="message_receiver")
public class MessageReceiver implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@ManyToOne
	@JoinColumn(name="fk_receiver")
	private User receiver;
	
	@ManyToOne
	@JoinColumn(name="fk_message")
	private Message message;
	
	public MessageReceiver(){}
}
