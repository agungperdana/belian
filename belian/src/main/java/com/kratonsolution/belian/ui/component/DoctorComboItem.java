/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import lombok.Getter;

import org.zkoss.zul.Comboitem;

import com.kratonsolution.belian.healtcare.dm.Doctor;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class DoctorComboItem extends Comboitem
{
	private Doctor doctor;
	
	public DoctorComboItem(Doctor doctor)
	{
		this.doctor = doctor;
		setLabel(doctor.getFrom().getName());
	}
}
