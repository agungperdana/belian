/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface RoledRepository extends JpaRepository<Roled, String>
{
	@Query("FROM Roled roled WHERE roled.party.id =:person AND roled.done IS FALSE AND roled.type = 'Approver' ")
	public List<Roled> findActiveApprover(@Param("person")String person);
	
	@Query("FROM Roled roled WHERE roled.party.id =:person AND roled.done IS FALSE AND roled.type = 'Reviewer' ")
	public List<Roled> findActiveReview(@Param("person")String person);
}
