/**
 * 
 */
package com.kratonsolution.belian.payments.dm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface PaymentApplicationRepository extends JpaRepository<PaymentApplication, String>
{
	public List<PaymentApplication> findAllByInvoiceId(String id);
}
