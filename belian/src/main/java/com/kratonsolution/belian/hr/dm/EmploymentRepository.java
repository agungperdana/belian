/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface EmploymentRepository extends JpaRepository<Employment, String>
{
	@Query("FROM Employment emp WHERE "
			+ "emp.internalOrganization.party.id IN(:company) "
			+ "ORDER BY emp.employee.party.name ASC")
	public List<Employment> findAll(Pageable pageable,@Param("company")List<String> companys);
	
	@Query("SELECT COUNT(emp) FROM Employment emp WHERE emp.internalOrganization.party.id =:company")
	public Long count(@Param("company")String id);
	
	@Query("FROM Employment emp WHERE emp.internalOrganization.party.id =:company ORDER BY emp.employee.party.name ASC")
	public List<Employment> findAll(@Param("company")String company);
	
	@Query("FROM Employment emp WHERE "
			+ "emp.internalOrganization.party.id IN(:company) "
			+ "ORDER BY emp.employee.party.name ASC")
	public List<Employment> findAll(@Param("company")List<String> company);
	
	@Query("FROM Employment emp WHERE "
			+ "emp.internalOrganization.party.id IN(:company) "
			+ "AND (emp.employee.party.identity LIKE %:key% "
			+ "OR emp.employee.party.name LIKE %:key%) "
			+ "ORDER BY emp.employee.party.name ASC")
	public List<Employment> findAll(@Param("company")List<String> company,@Param("key")String key);
	
	public Employment findOneByEmployeeId(String employee);
}
