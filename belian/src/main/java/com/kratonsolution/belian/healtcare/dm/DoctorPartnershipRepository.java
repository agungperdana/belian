/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface DoctorPartnershipRepository extends JpaRepository<DoctorPartnership, String>
{
	public DoctorPartnership findOneByParentIdAndChildId(String parentId,String childId);
}
