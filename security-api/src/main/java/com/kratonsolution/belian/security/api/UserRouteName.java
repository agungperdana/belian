package com.kratonsolution.belian.security.api;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface UserRouteName {

	String CREATE = "activemq:user-create?exchangePattern=InOut";
	String UPDATE = "activemq:user-update?exchangePattern=InOut";
	String DELETE = "activemq:user-delete?exchangePattern=InOut";
	String BY_NAME = "activemq:user-getbyname?exchangePattern=InOut";
	String BY_EMAIL = "activemq:user-getbyemail?exchangePattern=InOut";
	String ALL_USERS = "activemq:user-getallusers?exchangePattern=InOut";
	String ALL_USERS_PAGING = "activemq:user-getallusers-paging?exchangePattern=InOut";
	String ALL_USERS_FILTER = "activemq:user-getallusers-filter?exchangePattern=InOut";
	String COUNT = "activemq:user-count?exchangePattern=InOut";
	String COUNT_FILTER = "activemq:user-count-paging?exchangePattern=InOut";
	String ADD_ROLE = "activemq:user-add-new-user-role?exchangePattern=InOut";
	String UPDATE_ROLE = "activemq:user-update-user-role?exchangePattern=InOut";
	String DELETE_ROLE = "activemq:user-delete-user-role?exchangePattern=InOut";
	String CHANGE_PASSWORD = "activemq:user-change-password?exchangePattern=InOut";
}
