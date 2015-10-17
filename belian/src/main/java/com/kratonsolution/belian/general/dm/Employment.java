/**
 * 
 */
package com.kratonsolution.belian.general.dm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kratonsolution.belian.hr.dm.PayHistory;

/**
 * @author agungdodiperdana
 *
 */
@Entity
@Table(name="employment")
public class Employment extends PartyRelationship
{
	@OneToMany(mappedBy="employment",cascade=CascadeType.ALL)
	private Set<PayHistory> payHistorys = new HashSet<PayHistory>();
}