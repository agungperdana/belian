package com.kratonsolution.belian.access.role.api;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface RoleRouteName {

	String CREATE = "activemq:role-create?exchangePattern=InOut";
	String UPDATE = "activemq:role-update?exchangePattern=InOut";
	String DELETE = "activemq:role-delete?exchangePattern=InOut";
	String BY_CODE = "activemq:role-getbycode?exchangePattern=InOut";
	String ALL_ROLES = "activemq:role-getallroles?exchangePattern=InOut";
	String ALL_ROLES_PAGING = "activemq:role-getallroles-paging?exchangePattern=InOut";
	String ALL_ROLES_FILTER = "activemq:role-getallroles-filter?exchangePattern=InOut";
	String COUNT = "activemq:role-count?exchangePattern=InOut";
	String COUNT_FILTER = "activemq:role-count-paging?exchangePattern=InOut";
}
