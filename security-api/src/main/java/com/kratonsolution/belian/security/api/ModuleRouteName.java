package com.kratonsolution.belian.security.api;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface ModuleRouteName {

	String CREATE = "activemq:module-create?exchangePattern=InOut";
	String UPDATE = "activemq:module-update?exchangePattern=InOut";
	String DELETE = "activemq:module-delete?exchangePattern=InOut";
	String BY_CODE = "activemq:module-getbycode?exchangePattern=InOut";
	String ALL_MODULES = "activemq:module-getallmodules?exchangePattern=InOut";
	String ALL_MODULES_PAGING = "activemq:module-getallmodules-paging?exchangePattern=InOut";
	String ALL_MODULES_FILTER = "activemq:module-getallmodules-filter?exchangePattern=InOut";
	String COUNT = "activemq:module-count?exchangePattern=InOut";
	String COUNT_FILTER = "activemq:module-count-paging?exchangePattern=InOut";
}
