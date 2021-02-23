package com.kratonsolution.belian.geographic.api;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
public interface GeographicRouteName {
	
	String CRETATE = "activemq:geo-create?exchangePattern=InOut";
	String UPDATE = "activemq:geo-update?exchangePattern=InOut";
	String DELETE = "activemq:geo-delete?exchangePattern=InOut";
	String COUNT = "activemq:geo-count?exchangePattern=InOut";
	String COUNT_FILTER = "activemq:geo-count-filter?exchangePattern=InOut";
	String BY_CODE = "activemq:geo-getByCode?exchangePattern=InOut";
	String ALL_GEOGRAPHICS = "activemq:geo-getAllGeographics?exchangePattern=InOut";
	String ALL_GEOGRAPHICS_ROOTS = "activemq:geo-getAllGeographicRoots?exchangePattern=InOut";
	String ALL_GEOGRAPHICS_WITH_PAGING = "activemq:geo-getAllGeographics-paging?exchangePattern=InOut";
	String ALL_GEOGRAPHICS_WITH_FILTER = "activemq:geo-getAllGeographics-filter?exchangePattern=InOut";
	String ALL_BY_TYPE = "activemq:geo-getAllByType?exchangePattern=InOut";
}
