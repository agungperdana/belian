
package com.kratonsolution.belian.tools.dm;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="notification")
public class Notification implements Serializable
{
	@Id
	private String id;
	
	@Column(name="new_message")
	private Integer newMessage;
	
	@Version
	private Long version;
	
	public Notification(){}
	
	public void minus()
	{
		setNewMessage(getNewMessage()-1);
		if(getNewMessage() < 0)
			setNewMessage(0);
	}
	
	public void plus()
	{
		setNewMessage(getNewMessage()+1);
	}
}
