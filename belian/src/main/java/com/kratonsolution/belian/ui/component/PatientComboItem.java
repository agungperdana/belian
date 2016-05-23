/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import org.zkoss.zul.Comboitem;

import com.kratonsolution.belian.healtcare.dm.Patient;

import lombok.Getter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
public class PatientComboItem extends Comboitem
{
	private Patient patient;
	
	public PatientComboItem(Patient patient)
	{
		this.patient = patient;
		setLabel(patient.getFrom().getName());
		setValue(patient.getId());
	}
}
