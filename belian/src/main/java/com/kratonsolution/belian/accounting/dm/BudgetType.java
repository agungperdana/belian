/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.io.Serializable;

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
@Table(name="budget_type")
public class BudgetType implements Serializable
{
	@Id
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Version
	private Long version;
}
