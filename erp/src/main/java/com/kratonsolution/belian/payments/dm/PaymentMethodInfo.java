
package com.kratonsolution.belian.payments.dm;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
@Getter
@Setter
public class PaymentMethodInfo implements Serializable
{
	private PaymentMethodType paymentMethod = PaymentMethodType.CASH;
	
	private String reference;
	
	private PaymentMethodInfo(){};
	
	private PaymentMethodInfo(PaymentMethodType paymentMethod,String reference)
	{
		if(paymentMethod != null)
			this.paymentMethod = paymentMethod;
		
		this.reference = reference;
	}
	
	public static PaymentMethodInfo createInfo(PaymentMethodType paymentMethod,String reference)
	{
		return new PaymentMethodInfo(paymentMethod, reference);
	}
}
