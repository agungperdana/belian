/**
 * 
 */
package com.kratonsolution.belian.sales.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.asset.dm.Asset;
import com.kratonsolution.belian.general.dm.Person;
import com.kratonsolution.belian.hr.dm.WorkingShift;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="cashier_shift")
public class CashierShift implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="date")
	private Date date;

	@ManyToOne
	@JoinColumn(name="employee")
	private Person employee;
	
	@ManyToOne
	@JoinColumn(name="working_shift")
	private WorkingShift shift;
	
	@ManyToOne
	@JoinColumn(name="asset")
	private Asset machine;
	
	@Column(name="capital")
	private BigDecimal capital = BigDecimal.ZERO;
	
	@Column(name="start")
	private Time start;
	
	@Column(name="end")
	private Time end;
	
	@Version
	private Long version;
	
	public CashierShift(){}
}
