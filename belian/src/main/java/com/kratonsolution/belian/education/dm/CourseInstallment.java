/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="course_installment")
public class CourseInstallment implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="due_date")
	private Date dueDate;
	
	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="fk_course_registration")
	private CourseRegistration registration;
	
	@Version
	private Long version;
	
	public CourseInstallment(){}
}
