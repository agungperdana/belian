/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface EmploymentApplicationRepository extends JpaRepository<EmploymentApplication, String>
{
	public List<EmploymentApplication> findAllByStatusType(EmploymentApplicationStatusType statusType);
}
