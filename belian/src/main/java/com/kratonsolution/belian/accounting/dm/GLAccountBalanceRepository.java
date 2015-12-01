/**
 * 
 */
package com.kratonsolution.belian.accounting.dm;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface GLAccountBalanceRepository extends JpaRepository<GLAccountBalance, String>
{
	public GLAccountBalance findOneByPeriodAndAccount(String period,String account);
}
