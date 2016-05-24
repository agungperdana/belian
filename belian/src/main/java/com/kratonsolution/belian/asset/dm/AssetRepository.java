/**
 * 
 */
package com.kratonsolution.belian.asset.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface AssetRepository extends JpaRepository<Asset, String>
{
	@Query("FROM Asset asset WHERE asset.organization.id =:company ORDER BY asset.code,asset.name ASC")
	public List<Asset> findAll(@Param("company")String id);
	
	@Query("FROM Asset asset WHERE asset.organization.id =:company AND asset.usedBy IS NULL ORDER BY asset.code,asset.name ASC")
	public List<Asset> findAllUnused(@Param("company")String id);
	
	@Query("FROM Asset asset WHERE asset.organization.id =:company ORDER BY asset.code,asset.name ASC")
	public List<Asset> findAll(Pageable pageable,@Param("company")String id);
	
	@Query("SELECT COUNT(asset) FROM Asset asset WHERE asset.organization.id =:company")
	public Long count(@Param("company")String id);
}
