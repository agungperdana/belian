/**
 * 
 */
package com.kratonsolution.belian.global.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface QuickLaunchRepository extends JpaRepository<QuickLaunch, String>
{
	public List<QuickLaunch> findAllByUsername(String username);

	public QuickLaunch findOneByNameAndUsername(String name,String username);
}