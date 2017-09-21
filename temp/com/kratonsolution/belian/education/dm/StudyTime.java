/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.sql.Time;
import java.util.UUID;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.common.DateTimes;
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
@Table(name="study_time")
@Cacheable
public class StudyTime implements Listable
{
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name="start")
	private Time start;
	
	@Column(name="end")
	private Time end;
	
	@Version
	private Long version;
	
	public StudyTime(){}

	@Override
	public String getLabel()
	{
		return DateTimes.format(start)+"-"+DateTimes.format(end);
	}

	@Override
	public String getValue()
	{
		return getId();
	}
}
