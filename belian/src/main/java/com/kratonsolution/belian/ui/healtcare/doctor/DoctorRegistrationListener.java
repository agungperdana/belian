/**
 * 
 */
package com.kratonsolution.belian.ui.healtcare.doctor;

import java.io.Serializable;

import com.kratonsolution.belian.healtcare.dm.Doctor;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface DoctorRegistrationListener extends Serializable
{
	public void setDoctor(Doctor doctor);
}
