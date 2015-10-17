/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="pay_grade")
public class PayGrade implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Column(name="name")
	private String name;
	
	@Column(name="comment")
	private String comment;
	
	@Version
	private Long version;
	
	@OneToMany(mappedBy="payGrade",cascade=CascadeType.ALL)
	private Set<SalaryStep> steps = new HashSet<SalaryStep>();
}
