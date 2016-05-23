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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.kratonsolution.belian.general.dm.Party;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
@Entity
@Table(name="roled")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Roled implements Serializable
{
	@Id
	protected String id = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name="fk_party")
	protected Party party;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role_type")
	protected RoledType type = RoledType.Initiator;
	
	@Column(name="is_done")
	protected boolean done;
	
	@Version
	protected Long version;
	
	public Roled(){}
	
	public abstract ApproveAndReviewable getDocument();
}
