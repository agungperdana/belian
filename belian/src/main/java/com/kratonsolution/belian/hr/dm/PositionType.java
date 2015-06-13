/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

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
@Table(name="position_type")
public class PositionType
{
	@Id
	private String id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Version
	private Long version;
	
	//todo
}
