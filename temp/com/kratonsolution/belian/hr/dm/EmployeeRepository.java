/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface EmployeeRepository extends JpaRepository<Employee,String>
{
	public Employee findOneByPartyId(String personId);
	
	@Query("FROM Employee emp WHERE emp.party.name LIKE %:name% ORDER BY emp.party.name ASC")
	public List<Employee> findAll(@Param("name")String name);
}
