/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="tax")
public class Tax
{
	@Id
	private String id;
	
	@Column(name="code",nullable=false,unique=true)
	private String code;
	
	@Column(name="name",nullable=false,unique=true)
	private String name;
	
	@Column(name="value",nullable=false)
	private BigDecimal value = BigDecimal.ZERO;

	@Version
	private Long version;
}
