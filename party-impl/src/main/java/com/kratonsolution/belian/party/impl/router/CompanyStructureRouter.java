package com.kratonsolution.belian.party.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
import com.kratonsolution.belian.party.api.application.CompanyStructureCreateCommand;
import com.kratonsolution.belian.party.api.application.CompanyStructureDeleteCommand;
import com.kratonsolution.belian.party.api.application.CompanyStructureFilter;
import com.kratonsolution.belian.party.api.application.CompanyStructureService;
import com.kratonsolution.belian.party.api.application.CompanyStructureUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 2.0
 */
@Service
public class CompanyStructureRouter extends RouteBuilder {

	@Autowired
	private CompanyStructureService service;
	
	@Override
	public void configure() throws Exception {

		initRestRouter();
	}
	
	private void initRestRouter() {
	
		rest()
			.path("/company-structures/get")
			.get("/{code}")
			.route()
			.process(new AuthProcess("COM-STRC_READ"))
			.process(e->{
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.getByCode(e.getIn().getHeader("code", String.class))));
			})
			.endRest();
		
		rest()
			.path("/company-structures/all-roots")
			.get("/{page}/{size}")
			.route()
			.process(new AuthProcess("COM-STRC_READ"))
			.process(e->{
				
				CompanyStructureFilter filter = new CompanyStructureFilter();
				filter.setPage(e.getIn().getHeader("page", Integer.class));
				filter.setSize(e.getIn().getHeader("size", Integer.class));
				
				e.getMessage().setBody(ResponseBuilder.success(service.getAllRoot(filter)));
			})
			.endRest();
		
		rest()
			.path("/company-structures/all-roots")
			.get("/{page}/{size}/{key}")
			.route()
			.process(new AuthProcess("COM-STRC_READ"))
			.process(e->{
				
				CompanyStructureFilter filter = new CompanyStructureFilter();
				filter.setKey(e.getIn().getHeader("key", String.class));
				filter.setPage(e.getIn().getHeader("page", Integer.class));
				filter.setSize(e.getIn().getHeader("size", Integer.class));
				
				e.getMessage().setBody(ResponseBuilder.success(service.getAllRoot(filter)));
			})
			.endRest();
		
		rest()
			.path("/company-structures/all-company-structures")
			.get("/{page}/{size}")
			.route()
			.process(new AuthProcess("COM-STRC_READ"))
			.process(e->{
				
				CompanyStructureFilter filter = new CompanyStructureFilter();
				filter.setPage(e.getIn().getHeader("page", Integer.class));
				filter.setSize(e.getIn().getHeader("size", Integer.class));
				
				e.getMessage().setBody(ResponseBuilder.success(service.getAll(filter)));
			})
			.endRest();
	
		rest()
			.path("/company-structures/all-company-structures")
			.get("/{page}/{size}/{key}")
			.route()
			.process(new AuthProcess("COM-STRC_READ"))
			.process(e->{
				
				CompanyStructureFilter filter = new CompanyStructureFilter();
				filter.setKey(e.getIn().getHeader("key", String.class));
				filter.setPage(e.getIn().getHeader("page", Integer.class));
				filter.setSize(e.getIn().getHeader("size", Integer.class));
				
				e.getMessage().setBody(ResponseBuilder.success(service.getAll(filter)));
			})
			.endRest();
		
		rest()
			.path("/company-structures")
			.post("/create")
			.type(CompanyStructureCreateCommand.class)
			.route()
			.process(new AuthProcess("COM-STRC_ADD"))
			.process(e->{
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.create(e.getIn().getBody(CompanyStructureCreateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/company-structures")
			.put("/update")
			.type(CompanyStructureUpdateCommand.class)
			.route()
			.process(new AuthProcess("COM-STRC_EDIT"))
			.process(e->{
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.update(e.getIn().getBody(CompanyStructureUpdateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/company-structures")
			.delete("/delete")
			.type(CompanyStructureDeleteCommand.class)
			.route()
			.process(new AuthProcess("COM-STRC_DELETE"))
			.process(e->{
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.delete(e.getIn().getBody(CompanyStructureDeleteCommand.class))));
			})
			.endRest();
	}
}
