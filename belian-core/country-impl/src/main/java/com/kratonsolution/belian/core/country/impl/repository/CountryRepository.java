package com.kratonsolution.belian.core.country.impl.repository;

import com.kratonsolution.belian.core.country.impl.orm.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface CountryRepository extends JpaRepository<Country, String>
{
}
