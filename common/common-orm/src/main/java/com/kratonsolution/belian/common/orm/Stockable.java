package com.kratonsolution.belian.common.orm;

import java.math.BigDecimal;
import java.sql.Date;

import com.google.common.base.Strings;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.0.1
 */
public interface Stockable
{
	public IDValueRef getProduct();
	
	public BigDecimal getAccepted();
	
	public IDValueRef getFacility();
	
	public IDValueRef getContainer();
	
	public Date getExpired();
	
	public String getSerial();
	
	public default boolean isProductValid()
	{
		return getProduct() != null && !Strings.isNullOrEmpty(getProduct().getId());
	}
	
	public default boolean isFacilityValid()
	{
		return getFacility() != null && !Strings.isNullOrEmpty(getFacility().getId());
	}
	
	public default boolean isContainerValid()
	{
		return getContainer() != null && !Strings.isNullOrEmpty(getContainer().getId());
	}
}
