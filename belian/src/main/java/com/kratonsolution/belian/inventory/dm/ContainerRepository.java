/**
 * 
 */
package com.kratonsolution.belian.inventory.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ContainerRepository extends JpaRepository<Container, String>
{
	public Container findOneByName(String name);
}
