package com.kratonsolution.belian.geographic.api.connector;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.geographic.api.GeographicData;
import com.kratonsolution.belian.geographic.api.GeographicRouteName;
import com.kratonsolution.belian.geographic.api.GeographicType;
import com.kratonsolution.belian.geographic.api.application.GeographicCreateCommand;
import com.kratonsolution.belian.geographic.api.application.GeographicDeleteCommand;
import com.kratonsolution.belian.geographic.api.application.GeographicFilter;
import com.kratonsolution.belian.geographic.api.application.GeographicService;
import com.kratonsolution.belian.geographic.api.application.GeographicUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
@SuppressWarnings("unchecked")
public class GeographicServiceProxy implements GeographicService {

	@Autowired
	private ProducerTemplate producer;
	
	@Override
	public GeographicData create(@NonNull GeographicCreateCommand command) {

		return producer.requestBody(GeographicRouteName.CRETATE, command, GeographicData.class);
	}

	@Override
	public GeographicData update(@NonNull GeographicUpdateCommand command) {
		return producer.requestBody(GeographicRouteName.UPDATE, command, GeographicData.class);
	}

	@Override
	public GeographicData delete(@NonNull GeographicDeleteCommand command) {
		return producer.requestBody(GeographicRouteName.DELETE, command, GeographicData.class);
	}

	@Override
	public GeographicData getByCode(String code) {
		return producer.requestBody(GeographicRouteName.BY_CODE, code, GeographicData.class);
	}

	@Override
	public List<GeographicData> getAllGeographics() {
		return producer.requestBody(GeographicRouteName.ALL_GEOGRAPHICS, null, List.class);
	}

	@Override
	public List<GeographicData> getAllGeographicRoots() {
		return producer.requestBody(GeographicRouteName.ALL_GEOGRAPHICS_ROOTS, null, List.class);
	}

	@Override
	public List<GeographicData> getAllGeographics(int page, int size) {
		return producer.requestBody(GeographicRouteName.ALL_GEOGRAPHICS_WITH_PAGING, 
				new Object[]{page, size}, List.class);
	}

	@Override
	public List<GeographicData> getAllGeographics(GeographicFilter filter, int page, int size) {
		return producer.requestBody(GeographicRouteName.ALL_GEOGRAPHICS_WITH_FILTER, 
				new Object[] {filter, page, size}, List.class);
	}

	public int count() {
		return this.producer.requestBody(GeographicRouteName.COUNT, null, Integer.class);
	}

	@Override
	public int count(GeographicFilter filter) {
		return this.producer.requestBody(GeographicRouteName.COUNT_FILTER, filter, Integer.class);
	}

	@Override
	public List<GeographicData> getAllByType(GeographicType type) {
		return this.producer.requestBody(GeographicRouteName.ALL_BY_TYPE, type, List.class);
	}
}
