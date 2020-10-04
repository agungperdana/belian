package com.kratonsolution.belian.product.impl.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Getter
@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 5130698686357598011L;
	
	@Id
	private String id = UUID.randomUUID().toString();

	@Column(name = "name")
	private String name;
	
	private Instant introducingDate;
	
	private Instant salesDiscontinuationDate;
	
	private Instant supportDiscontinuationDate;
	
	private String comment;
}
