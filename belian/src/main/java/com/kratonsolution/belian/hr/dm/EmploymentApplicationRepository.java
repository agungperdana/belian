/**
 * 
 */
package com.kratonsolution.belian.hr.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface EmploymentApplicationRepository extends JpaRepository<EmploymentApplication, String>
{
	public List<EmploymentApplication> findAllByStatusType(EmploymentApplication.StatusType statusType);
}
