
package com.kratonsolution.belian.hr.dm;

import java.sql.Date;
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
			+ "emp.toParty.id =:company "
			+ "ORDER BY emp.fromParty.name ASC")
	public List<Employment> findAll(Pageable pageable,@Param("company")String company);
	
	@Query("SELECT COUNT(emp) FROM Employment emp WHERE emp.toParty.id =:company")
	public Long count(@Param("company")String id);
	
	@Query("FROM Employment emp WHERE emp.toParty.id =:company ORDER BY emp.fromParty.name ASC")
	public List<Employment> findAll(@Param("company")String company);
	
	@Query("FROM Employment emp WHERE "
			+ "emp.toParty.id =:company "
			+ "AND (emp.fromParty.code LIKE %:key% "
			+ "OR emp.fromParty.name LIKE %:key%) "
			+ "ORDER BY emp.fromParty.name ASC")
	public List<Employment> findAll(Pageable pageable,@Param("company")String company,@Param("key")String key);
	
	@Query("SELECT COUNT(emp) FROM Employment emp WHERE "
			+ "emp.toParty.id =:company "
			+ "AND (emp.fromParty.code LIKE %:key% "
			+ "OR emp.fromParty.name LIKE %:key%) ")
	public Long count(@Param("company")String company,@Param("key")String key);
	
	@Query("FROM Employment emp WHERE "
			+ "emp.toParty.id =:company "
			+ "AND emp.fromParty.id =:employee "
			+ "ORDER BY emp.toParty.name ASC ")
	public List<Employment> findAll(@Param("employe")String employee,@Param("company")String company);
	
	@Query("FROM Employment emp WHERE "
			+ "emp.fromRole.id =:employee "
			+ "AND emp.fromParty.id =:person "
			+ "AND ((:date BETWEEN emp.start AND emp.end) OR (emp.start <= :date AND emp.end IS NULL)) "
			+ "ORDER BY emp.toParty.name ASC ")
	public List<Employment> findAll(@Param("employee")String employee,@Param("person")String person,@Param("date")Date currentDate);
}
