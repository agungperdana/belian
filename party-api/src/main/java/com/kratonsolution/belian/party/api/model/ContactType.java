package com.kratonsolution.belian.party.api.model;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 1.0
 */
public enum ContactType
{
	CELL_PHONE,
	HOME_PHONE,
	OFFICE_PHONE,
	PAGER,
	EMAIL,
	POSTBOX;
	
	@Override
	public String toString() {
		
		if(this.equals(CELL_PHONE)) {
			return "Cell Phone";
		}
		else if(this.equals(HOME_PHONE)) {
			return "Home Phone";
		}
		else if(this.equals(OFFICE_PHONE)) {
			return "Office Phone";
		}
		else if(this.equals(PAGER)) {
			return "Pager";
		}
		else if(this.equals(EMAIL)) {
			return "Email";
		}
		
		return "Post Box";
	}
}
