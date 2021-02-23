package com.kratonsolution.belian.party.api.model;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public enum PartyRoleType
{
	EMPLOYEE,
	EMPLOYER,
	CONTRACTOR,
	FAMILY_MEMBER,
	CONTACT,
	PROSPECT,
	SHAREHOLDER,
	CUSTOMER,
	SUPPLIER,
	AGENT,
	DISTRIBUTOR,
	PARENT_ORGANIZATION,
	SUBSIDIARY,
	BRANCH,
	DIVISION,
	DEPARTMENT,
	HEALTCARE_PRACTITIONER,
	HEALTCARE_PROVIDER,
	INTERNAL_ORGANIZATION;
	
	@Override
	public String toString() {
		
		switch (this) {
		
			case EMPLOYEE:return "Employee";
			case EMPLOYER:return "Employer";
			case CONTRACTOR:return "Contractor";
			case FAMILY_MEMBER:return "Family Member";
			case CONTACT:return "Contact";
			case PROSPECT:return "Prospect";
			case SHAREHOLDER:return "Shareholder";
			case CUSTOMER:return "Customer";
			case SUPPLIER:return "Supplier";
			case AGENT:return "Agent";
			case DISTRIBUTOR:return "Distributor";
			case PARENT_ORGANIZATION:return "Parent Organization";
			case SUBSIDIARY:return "Subsidiary";
			case BRANCH:return "Branch";
			case DIVISION:return "Division";
			case DEPARTMENT:return "Department";
			case HEALTCARE_PRACTITIONER:return "Healthcare Practitioner";
			case HEALTCARE_PROVIDER:return "Healthcare Provider";
			default:return "Internal Organization";
		}
	}
}
