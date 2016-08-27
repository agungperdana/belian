/**
 * 
 */
package com.kratonsolution.belian.facility.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface FacilityRepository extends JpaRepository<Facility, String>
{
	public Facility findOneByCode(String code);
	
	public Facility findOneByName(String name);
	
	public List<Facility> findAllByType(String type);
	
	@Query("FROM Facility fac WHERE fac.parent IS NULL ORDER BY fac.code,fac.name ASC")
	public List<Facility> findAllParent();
	
	@Query("FROM Facility fac WHERE fac.parent IS NULL ORDER BY fac.name ASC")
	public List<Facility> findAllParent(Pageable pageable);
	
	@Query("SELECT COUNT(fac) FROM Facility fac WHERE fac.parent IS NULL")
	public Long size();
}
