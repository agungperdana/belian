/**
 * 
 */
package com.kratonsolution.belian.partys.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.general.dm.IndustrySegmentation;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface OrganizationRepository extends JpaRepository<Organization, String>
{
	public List<Organization> findAllByType(IndustrySegmentation type);

	@Query("FROM Organization org WHERE org.id NOT IN(:ids)")
	public List<Organization> findAllNot(@Param("ids")List<String> ids);
}
