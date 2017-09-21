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
public interface AutoJournalSettingRepository extends JpaRepository<AutoJournalSetting, String>
{
	public AutoJournalSetting findOneByOrganizationId(String id);

	@Query("FROM AutoJournalSetting setting WHERE "
			+ "setting.organization.id IN(:companys) ")
	public List<AutoJournalSetting> findAll(Pageable pageable,@Param("companys")List<String> companys);
	
	@Query("SELECT COUNT(setting) FROM AutoJournalSetting setting WHERE "
			+ "setting.organization.id IN(:companys) ")
	public int count(@Param("companys")List<String> companys);
}
