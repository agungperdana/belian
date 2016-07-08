/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="study_day")
public class StudyDay implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="is_sunday")
	private boolean sunday;
	
	@Column(name="is_monday")
	private boolean monday;
	
	@Column(name="is_tuesday")
	private boolean tuesday;
	
	@Column(name="is_wednesday")
	private boolean wednesday;

	@Column(name="is_thrusday")
	private boolean thursday;
	
	@Column(name="is_friday")
	private boolean friday;
	
	@Column(name="is_saturday")
	private boolean saturday;

	@Version
	private Long version;
	
	public StudyDay(){}
}
