/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum PartyRelationshipType
{
	EMPLOYMENT_RELATIONSHIP("Kepegawaian","Employment Relationship"),
	CUSTOMER_RELATIONSHIP("Hubungan Pelanggan","Customer Relationship"),
	SUPPLIER_RELATIONSHIP("Hubungan Pemasok","Supplier Relationship"),
	CONTACT_PERSON_RELATIONSHIP("Kontak","Contact Person Relationship"),
	PATIENT_PROVIDER_RELATIONSHIP("Hubungan Pasien-Penyedia Jasa","Patient Provider Realtionship"),
	PATIENT_PRACTITIONER_RELATIONSHIP("Hubungan Pasien-Dokter","Patient Practitioner Realtionship"),
	PRACTITIONER_PROVIDER_RELATIONSHIP("Hubungan Dokter-Penyedia Jasa","Practitioner-Provider Realtionship"),
	ORGANIZATION_ROLLUP("Struktur Organisasi","Company Structure");
	
	private String inID;

	private String enUS;

	private PartyRelationshipType(String inID,String enUS)
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
