/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kratonsolution.belian.global.dm.Acknowledgement;

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
public class RequestRole extends Acknowledgement
{
	@ManyToOne
	@JoinColumn(name="fk_request")
	private Request request;
	
	public RequestRole(){}

	@Override
	public String getOrigin()
	{
		return request.getOriginator().getValue();
	}

	@Override
	public String getResponding()
	{
		return request.getResponding().getValue();
	}

	@Override
	public Set<RequestItem> getDetails()
	{
		return request.getItems();
	}

	@Override
	public Date getDate()
	{
		return request.getEntryDate();
	}
}
