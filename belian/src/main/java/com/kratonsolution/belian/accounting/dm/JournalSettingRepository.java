/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface JournalSettingRepository extends JpaRepository<JournalSetting, String>
{
	public JournalSetting findOneByOrganizationId(String id);
}
