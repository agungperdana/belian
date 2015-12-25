/**
 * 
 */
package com.kratonsolution.belian.healtcare.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PatientRepository extends JpaRepository<Patient, String>
{
	public Patient findOneByBpjsCard(String bpjsCardNumber);
	
	public Patient findOneByPartyId(String id);
}