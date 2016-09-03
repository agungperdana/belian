/**
 * 
 */
package com.kratonsolution.belian.education.dm;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public enum StudentGrade
{
	ELEMENTARTY_1("Kelas 1","Grade 1"),
	ELEMENTARTY_2("Kelas 2","Grade 2"),
	ELEMENTARTY_3("Kelas 3","Grade 3"),
	ELEMENTARTY_4("Kelas 4","Grade 4"),
	ELEMENTARTY_5("Kelas 5","Grade 5"),
	ELEMENTARTY_6("Kelas 6","Grade 6"),
	JUNIOR_1("Kelas 7","Grade 7"),
	JUNIOR_2("Kelas 8","Grade 8"),
	JUNIOR_3("Kelas 9","Grade 9"),
	SENIOR_1("Kelas 10","Grade 10"),
	SENIOR_2("Kelas 11","Grade 11"),
	SENIOR_3("Kelas 12","Grade 12");
	
	private String inID;
	
	private String enUS;
	
	private StudentGrade(String inID,String enUS)
	{
		this.inID = inID;
		this.enUS = enUS;
	}
	
	public String display(String lang)
	{
		if(lang == null || lang.equals("") || lang.equalsIgnoreCase("in_ID"))
			return this.inID;
		
		return enUS;
	}
}
