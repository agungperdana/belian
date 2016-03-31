/**
 * 
 */
package com.kratonsolution.belian.asset.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface AssetTypeRepository extends JpaRepository<AssetType, String>
{
	public List<AssetType> findAllByParentIsNull();
}
