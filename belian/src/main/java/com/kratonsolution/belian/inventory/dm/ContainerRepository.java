/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author agungdodiperdana
 *
 */
public interface ContainerRepository extends JpaRepository<Container, String>
{
	public List<Container> findAllByFacilityId(String facilityId);
}
