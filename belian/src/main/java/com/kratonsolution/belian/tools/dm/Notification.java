/**
 * 
 */
package com.kratonsolution.belian.tools.dm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

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
