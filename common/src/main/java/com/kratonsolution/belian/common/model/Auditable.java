package com.kratonsolution.belian.common.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
@Getter
@Setter
@MappedSuperclass
public abstract class Auditable {

	@Column(name = "created_by")
    protected String createdBy;
    
	@Column(name = "created_date")
    protected Instant createdDate;
    
	@Column(name = "last_updated_by")
    protected String lastUpdatedBy;
    
	@Column(name = "last_updated_date")
    protected Instant lastUpdatedDate;
}
