
package com.kratonsolution.belian.healtcares.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum HealthcareDeliveryType
{
	EXAMINATION("Pemeriksaan","Examination"),
	DRUG_ADMINISTRATION("Pemberian Obat","Drug Administration"),
	PROCEDURE_DELIVERY("Tindakan Medis","Procedure");
	
	private String inID;

	private String enUS;

	private HealthcareDeliveryType(String inID,String enUS)
	{
		this.inID = inID;
		this.enUS = enUS;
	}

	public String display()
	{
		return this.enUS;
	}

	public String display(String lang)
	{
		if(lang == null || lang.equals("") || lang.equalsIgnoreCase("en_US"))
			return this.enUS;

		return this.inID;
	}
}
