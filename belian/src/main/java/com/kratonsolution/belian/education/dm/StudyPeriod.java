/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.global.dm.Listable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="study_period")
public class StudyPeriod implements Listable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="name",unique=true,nullable=false)
	private String name;

	@Column(name="note")
	private String note;

	@Version
	private Long version;

	public StudyPeriod()
	{
	}

	@Override
	public String getLabel()
	{
		return getName();
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
