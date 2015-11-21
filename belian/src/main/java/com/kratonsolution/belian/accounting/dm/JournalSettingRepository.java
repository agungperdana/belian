/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface JournalSettingRepository extends JpaRepository<JournalSetting, String>
{
	public JournalSetting findOneByOrganizationId(String id);
	
	@Query("FROM JournalSetting setting WHERE setting.organization.id IN :companys")
	public List<JournalSetting> findAll(Pageable pageable,@Param("companys")List<String> companys);
}
