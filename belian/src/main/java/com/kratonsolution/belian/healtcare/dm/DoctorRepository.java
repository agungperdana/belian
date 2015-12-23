/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratonsolution.belian.general.dm.PartyRole.Type;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface DoctorRepository extends JpaRepository<Doctor, String>
{
	public Doctor findOneByPartyIdAndType(String id,Type type);
}
