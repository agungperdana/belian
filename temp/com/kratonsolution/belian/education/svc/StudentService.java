/**
 * 
 */
package com.kratonsolution.belian.education.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Strings;
import com.kratonsolution.belian.education.dm.Student;
import com.kratonsolution.belian.education.dm.StudentRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class StudentService
{
	@Autowired
	private StudentRepository repository;
		
	@Secured({"ROLE_STUDENT_READ","ROLE_SYSTEM_READ"})
	public Student findOne(String id)
	{
		if(!Strings.isNullOrEmpty(id))
			return repository.findOne(id);
	
		return null;
	}
	
	@Secured({"ROLE_STUDENT_READ","ROLE_SYSTEM_READ"})
	public List<Student> findAll()
	{
		return repository.findAll();
	}
	
	@Secured({"ROLE_STUDENT_READ"})
	public int getSize()
	{
		return (int)repository.count();
	}
	
	@Secured("ROLE_STUDENT_CREATE")
	public void add(Student day)
	{
		repository.save(day);
	}
	
	@Secured("ROLE_STUDENT_UPDATE")
	public void edit(Student day)
	{
		repository.saveAndFlush(day);
	}
	
	@Secured("ROLE_STUDENT_DELETE")
	public void delete(String id)
	{
		repository.delete(id);
	}
	
	@Secured("ROLE_STUDENT_READ")
	public List<Student> findAll(int pageIndex,int itemsSize)
	{
		return repository.findAll(new PageRequest(pageIndex, itemsSize)).getContent();
	}
}
