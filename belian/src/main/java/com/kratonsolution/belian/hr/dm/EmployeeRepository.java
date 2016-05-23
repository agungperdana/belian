/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface EmployeeRepository extends JpaRepository<Employee,String>
{
	public Employee findOneByPartyId(String personId);
}
