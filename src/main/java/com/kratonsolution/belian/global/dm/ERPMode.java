/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.IndustrySegmentation;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="erp_mode")
public class ERPMode implements Serializable
{
	@Id
	private String id = UUID.randomUUID().toString();
	
	@Enumerated(EnumType.STRING)
	@Column(name="segmentation")
	private IndustrySegmentation segmentation = IndustrySegmentation.GENERAL;

	@Version
	private Long version;
	
	public ERPMode(){}
}
