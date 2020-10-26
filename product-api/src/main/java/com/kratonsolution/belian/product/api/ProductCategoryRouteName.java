package com.kratonsolution.belian.product.api;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0.0
 */
public interface ProductCategoryRouteName {

	String CRETATE = "activemq:prod-cat-create?exchangePattern=InOut";
	String UPDATE = "activemq:prod-cat-update?exchangePattern=InOut";
	String DELETE = "activemq:prod-cat-delete?exchangePattern=InOut";
	String COUNT = "activemq:prod-cat-count?exchangePattern=InOut";
	String COUNT_FILTER = "activemq:prod-cat-count-filter?exchangePattern=InOut";
	String BY_ID = "activemq:prod-cat-getByID?exchangePattern=InOut";
	String BY_NAME = "activemq:prod-cat-getByName?exchangePattern=InOut";
	String GET_ALL = "activemq:prod-cat-getAll?exchangePattern=InOut";
	String GET_ALL_WITH_PAGING = "activemq:prod-cat-getAllWithPaging?exchangePattern=InOut";
	String GET_ALL_FILTER = "activemq:prod-cat-getAll?exchangePattern=InOut";
}
