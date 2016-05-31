/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.patient;

import java.io.Serializable;

import com.kratonsolution.belian.healtcare.dm.Patient;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PatientRegistrationListener extends Serializable
{
	public void setPatient(Patient patient);
}
