package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import com.kratonsolution.belian.core.industrysegmentation.impl.orm.IndustrySegmentation;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
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
