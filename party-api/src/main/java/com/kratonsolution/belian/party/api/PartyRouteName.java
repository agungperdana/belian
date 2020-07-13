package com.kratonsolution.belian.party.api;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface PartyRouteName {

	String CREATE = "activemq:party-create?exchangePattern=InOut";

	String UPDATE = "activemq:party-update?exchangePattern=InOut";

	String DELETE = "activemq:party-delete?exchangePattern=InOut";

	String COUNT = "activemq:party-count?exchangePattern=InOut";

	String COUNT_WITH_TYPE = "activemq:party-count-type?exchangePattern=InOut";

	String COUNT_WITH_FILTER = "activemq:party-count-filter?exchangePattern=InOut";

	String BY_ID = "activemq:party-get-byid?exchangePattern=InOut";

	String BY_CODE = "activemq:party-get-bycode?exchangePattern=InOut";

	String ALL_PARTYS = "activemq:party-get-allpartys?exchangePattern=InOut";

	String ALL_PARTYS_TYPE = "activemq:party-get-allpartys-type?exchangePattern=InOut";

	String ALL_PARTYS_TYPE_PAGING = "activemq:party-get-allpartys-type-paging?exchangePattern=InOut";

	String ALL_PARTYS_PAGING = "activemq:party-get-allpartys-paging?exchangePattern=InOut";

	String ALL_PARTYS_FILTER_PAGING = "activemq:party-get-allpartys-filter-paging?exchangePattern=InOut";

	String CREATE_ADDRESS = "activemq:party-create-address?exchangePattern=InOut";

	String UPDATE_ADDRESS = "activemq:party-update-address?exchangePattern=InOut";

	String DELETE_ADDRESS = "activemq:party-delete-address?exchangePattern=InOut";

	String CREATE_CONTACT = "activemq:party-create-contact?exchangePattern=InOut";

	String UPDATE_CONTACT = "activemq:party-update-contact?exchangePattern=InOut";

	String DELETE_CONTACT = "activemq:party-delete-contact?exchangePattern=InOut";

	String CREATE_ROLE = "activemq:party-create-role?exchangePattern=InOut";

	String UPDATE_ROLE = "activemq:party-update-role?exchangePattern=InOut";

	String DELETE_ROLE = "activemq:party-delete-role?exchangePattern=InOut";

	String CREATE_RELATIONSHIP = "activemq:party-create-relationship?exchangePattern=InOut";

	String UPDATE_RELATIONSHIP = "activemq:party-update-relationship?exchangePattern=InOut";

	String DELETE_RELATIONSHIP = "activemq:party-delete-relationship?exchangePattern=InOut";

	String CREATE_CLASSIFICATION = "activemq:party-create-classification?exchangePattern=InOut";

	String UPDATE_CLASSIFICATION = "activemq:party-update-classification?exchangePattern=InOut";

	String DELETE_CLASSIFICATION = "activemq:party-delete-classification?exchangePattern=InOut";
}
