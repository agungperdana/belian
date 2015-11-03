/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface AccountingSettingAccountRepository extends JpaRepository<AccountingSettingAccount, String>
{
	public AccountingSettingAccount findOneByOrganizationIdAndType(String organization,AccountingSettingType type);
	
	public List<AccountingSettingAccount> findAllByType(AccountingSettingType type);
}
