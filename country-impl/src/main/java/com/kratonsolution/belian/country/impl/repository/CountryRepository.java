
package com.kratonsolution.belian.country.impl.repository;

import com.kratonsolution.belian.country.impl.orm.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface CountryRepository extends JpaRepository<Country, String>
{
}
