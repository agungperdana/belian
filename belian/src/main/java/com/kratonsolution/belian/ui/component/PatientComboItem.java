/**
 * 
 */
package com.kratonsolution.belian.ui.component;

import lombok.Getter;

import org.zkoss.zul.Comboitem;

import com.kratonsolution.belian.healtcare.dm.Patient;

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
		setLabel(patient.getPerson().getName());
		setValue(patient.getId());
	}
}
