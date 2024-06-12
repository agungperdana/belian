package com.kratonsolution.belian.facility.impl.repository;

import com.kratonsolution.belian.facility.impl.orm.Container;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface ContainerRepository extends JpaRepository<Container, String>
{
	public Container findByName(String name);
}
