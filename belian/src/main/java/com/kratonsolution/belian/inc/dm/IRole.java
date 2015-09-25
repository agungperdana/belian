/**
 * 
 */
package com.kratonsolution.belian.inc.dm;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author agungdodiperdana
 *
 */
@Getter
@Setter
@Entity
@Table(name="i_role")
@Inheritance(strategy=InheritanceType.JOINED)
public class IRole
{
	@Id
	protected String id = UUID.randomUUID().toString();

	@Column(name="name")
	protected String name;
}
