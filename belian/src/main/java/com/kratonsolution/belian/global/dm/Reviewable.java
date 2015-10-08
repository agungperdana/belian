/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
@Table(name="reviewable")
@Inheritance(strategy=InheritanceType.JOINED)
public class Reviewable implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@Column(name="is_approved")
	protected boolean approved;
	
	@Version
	protected Long version;

	@OneToMany(mappedBy="reviewable",cascade=CascadeType.ALL)
	@OrderBy("date ASC")
	protected Set<ReviewResult> reviews = new HashSet<ReviewResult>();
}
