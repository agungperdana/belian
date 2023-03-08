/**
 * 
 */
package com.kratonsolution.belian.orders.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.global.dm.ApproverStatus;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface RequestRoleRepository extends JpaRepository<RequestRole, String>
{
	public List<RequestRole> findAllByApproverStatusAndPersonId(ApproverStatus status,String person);
	
	@Query("FROM RequestRole role WHERE "
			+ "role.approverStatus = 'SUBMITTED' "
			+ "AND role.type IN('REVIEWER','APPROVER') "
			+ "AND role.person.id =:person "
			+ "ORDER BY role.request.entryDate DESC")
	public List<RequestRole> findAllForApprovalAndReview(@Param("person")String person);
}
