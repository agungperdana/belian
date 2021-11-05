package com.kratonsolution.belian.companystructure.driver.jms;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
@SuppressWarnings("unchecked")
public class CompanyStructureJmsDriver {

	static final String CREATE = "activemq:company-structure-create?exchangePattern=InOut";
	static final String UPDATE = "activemq:company-structure-update?exchangePattern=InOut";
	static final String DELETE = "activemq:company-structure-delete?exchangePattern=InOut";
	static final String BY_CODE = "activemq:company-structure-get-by-code?exchangePattern=InOut";
	static final String ALL_ROOTS = "activemq:company-structure-get-all-roots?exchangePattern=InOut";
	static final String ALL_DATA = "activemq:company-structure-all?exchangePattern=InOut";
	static final String ALL_FILTER = "activemq:company-structure-get-all-filter?exchangePattern=InOut";
	static final String ALL_BY_PARENT = "activemq:company-structure-get-all-by-parent?exchangePattern=InOut";
	static final String COUNT_FILTER = "activemq:company-structure-count-paging?exchangePattern=InOut";
	
	@Autowired
	private ProducerTemplate producer;
	
	private Gson parser = new Gson();

	public CompanyStructureData create(@NonNull CompanyStructureCreateCommand command) {
		
		return parser.fromJson(producer.requestBody(CREATE, parser.toJson(command), String.class), CompanyStructureData.class);
	}

	public CompanyStructureData update(@NonNull CompanyStructureUpdateCommand command) {
		
		return parser.fromJson(producer.requestBody(UPDATE, parser.toJson(command), String.class), CompanyStructureData.class);
	}

	public CompanyStructureData delete(@NonNull CompanyStructureDeleteCommand command) {
		
		return parser.fromJson(producer.requestBody(DELETE, parser.toJson(command), String.class), CompanyStructureData.class);
	}

	public CompanyStructureData getByCode(@NonNull String code) {
		
		return parser.fromJson(producer.requestBody(BY_CODE, code, String.class), CompanyStructureData.class);
	}
	
	public List<CompanyStructureData> getAllStructure(@NonNull String topLevelCode) {
		
		return parser.fromJson(producer.requestBody(ALL_BY_PARENT, topLevelCode, String.class), List.class);
	}

	public List<CompanyStructureData> getAllCompanyStructures() {
		return parser.fromJson(producer.requestBody(ALL_DATA, null, String.class), List.class);
	}

	public List<CompanyStructureData> getAllCompanyStructureRoots() {
		return parser.fromJson(producer.requestBody(ALL_ROOTS, null, String.class), List.class);
	}

	public List<CompanyStructureData> getAllCompanyStructures(@NonNull CompanyStructureFilter filter) {
		
		return parser.fromJson(producer.requestBody(ALL_FILTER, parser.toJson(filter), String.class), List.class);
	}

	public int count(@NonNull CompanyStructureFilter filter) {
		return parser.fromJson(producer.requestBody(COUNT_FILTER, parser.toJson(filter), String.class), Integer.class);
	}
}
