package com.kratonsolution.belian.party.api.model;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public enum AddressType
{
	HOME, OFFICE, WAREHOUSE;
	
	@Override
	public String toString() {

		switch (this) {
			case WAREHOUSE:return "Warehouse";
			case OFFICE:return "Office";
			default:return "Home";
		}
	}
}
