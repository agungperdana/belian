/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import com.google.common.base.Strings;

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
	
	public String toGradeString(String name)
	{
		if(Strings.isNullOrEmpty(name))
			return "";
		
		if(name.equals("Kelas 1") || name.equals("Grade 1"))
			return StudentGrade.ELEMENTARTY_1.name();
		else if(name.equals("Kelas 2") || name.equals("Grade 2"))
			return StudentGrade.ELEMENTARTY_2.name();
		else if(name.equals("Kelas 3") || name.equals("Grade 3"))
			return StudentGrade.ELEMENTARTY_3.name();
		else if(name.equals("Kelas 4") || name.equals("Grade 4"))
			return StudentGrade.ELEMENTARTY_4.name();
		else if(name.equals("Kelas 5") || name.equals("Grade 5"))
			return StudentGrade.ELEMENTARTY_5.name();
		else if(name.equals("Kelas 6") || name.equals("Grade 6"))
			return StudentGrade.ELEMENTARTY_6.name();
		else if(name.equals("Kelas 7") || name.equals("Grade 7"))
			return StudentGrade.JUNIOR_1.name();
		else if(name.equals("Kelas 8") || name.equals("Grade 8"))
			return StudentGrade.JUNIOR_2.name();
		else if(name.equals("Kelas 9") || name.equals("Grade 9"))
			return StudentGrade.JUNIOR_3.name();
		else if(name.equals("Kelas 10") || name.equals("Grade 10"))
			return StudentGrade.SENIOR_1.name();
		else if(name.equals("Kelas 11") || name.equals("Grade 11"))
			return StudentGrade.SENIOR_2.name();
		else if(name.equals("Kelas 12") || name.equals("Grade 12"))
			return StudentGrade.SENIOR_3.name();
		else
			return "";
	}
}
