package com.kratonsolution.belian.companystructure.adapter.jms;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kratonsolution.belian.companystructure.api.application.CompanyStructureCreateCommand;
import com.kratonsolution.belian.companystructure.api.application.CompanyStructureDeleteCommand;
import com.kratonsolution.belian.companystructure.api.application.CompanyStructureFilter;
import com.kratonsolution.belian.companystructure.api.application.CompanyStructureService;
import com.kratonsolution.belian.companystructure.api.application.CompanyStructureUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
public class CompanyStructureJmsAdapter extends RouteBuilder {

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
	private CompanyStructureService service;
	
	private Gson parser = new Gson();

	@Override
	public void configure() throws Exception {

		from(CREATE).process(e-> {
			
			e.getMessage().setBody(
					parser.toJson(
						service.create(parser.fromJson(e.getIn().getBody(String.class), CompanyStructureCreateCommand.class))
					));
		});

		from(UPDATE).process(e-> {
		
			e.getMessage().setBody(
					parser.toJson(
							service.update(parser.fromJson(e.getIn().getBody(String.class), CompanyStructureUpdateCommand.class))));
		});

		from(DELETE).process(e->
			e.getMessage().setBody(
					parser.toJson(
							service.delete(parser.fromJson(e.getIn().getBody(String.class), CompanyStructureDeleteCommand.class))))
		);

		from(BY_CODE).process(e -> e.getMessage().setBody(parser.toJson(service.getByCode(e.getIn().getBody(String.class)))));
		
		from(ALL_BY_PARENT).process(e->
			e.getMessage().setBody(parser.toJson(service.getAllStructure(e.getIn().getBody(String.class)))));	

		from(ALL_ROOTS).process(e -> e.getMessage().setBody(parser.toJson(service.getAllCompanyStructureRoots())));

		from(ALL_DATA).process(e-> e.getMessage().setBody(parser.toJson(service.getAllCompanyStructures())));

		from(ALL_FILTER).process(e-> 
			e.getMessage().setBody(
					parser.toJson(
							service.getAllCompanyStructures(parser.fromJson(e.getIn().getBody(String.class), CompanyStructureFilter.class))))
		);

		from(COUNT_FILTER).process(e -> 
			e.getMessage().setBody(
					service.count(parser.fromJson(e.getIn().getBody(String.class), CompanyStructureFilter.class)))
		);
	}
}
