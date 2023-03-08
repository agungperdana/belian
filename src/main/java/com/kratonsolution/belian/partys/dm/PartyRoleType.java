/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum PartyRoleType
{
	EMPLOYEE("Pegawai","Employee"),
	EMPLOYER("Pemberi Kerja","Employer"),
	CONTRACTOR("Kontraktor","Contractor"),
	FAMILY_MEMBER("Anggota Keluarga","Family Member"),
	CONTACT("Kontak","Contact"),
	PROSPECT("Prospek","Prospect"),
	SHAREHOLDER("Pemegang Saham","Shareholder"),
	CUSTOMER("Pelanggan","Customer"),
	SUPPLIER("Penyuplai","Supplier"),
	AGENT("Agen","Agent"),
	DISTRIBUTOR("Pendistribusi","Distributor"),
	PARENT_ORGANIZATION("Induk Organisasi","Parent Organisasi"),
	SUBSIDIARY("Anak Perusahaan","Subsidiary"),
	BRANCH("Cabang Perusahaan","Branch"),
	DIVISION("Divisi","Division"),
	DEPARTMENT("Departemen","Department"),
	HEALTCARE_PRACTITIONER("Praktisi Kesehatan","Healtcare Practitioner"),
	HEALTCARE_PROVICER("Penyedia Jasa Kesehatan","Healtcare Provider"),
	INTERNAL_ORGANIZATION("Linkar Dalam Organisasi ","Internal Organisasi");
	
	private String inID;

	private String enUS;

	private PartyRoleType(String inID,String enUS)
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
