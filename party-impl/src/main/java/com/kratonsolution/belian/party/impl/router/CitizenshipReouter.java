package com.kratonsolution.belian.party.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
import com.kratonsolution.belian.party.api.application.CitizenshipCreateCommand;
import com.kratonsolution.belian.party.api.application.CitizenshipDeleteCommand;
import com.kratonsolution.belian.party.api.application.CitizenshipUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Component
public class CitizenshipReouter extends RouteBuilder {

	@Autowired
	private PartyService service;

	@Override
	public void configure() throws Exception {

		initJMS();
		initRest();
	}

	private void initJMS() {

	}
	
	private void initRest() {
		
		rest()
			.path("/partys/citizenships")
			.post("/create")
			.type(CitizenshipCreateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_ADD"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.createCitizenship(
										e.getIn().getBody(CitizenshipCreateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/citizenships")
			.put("/update")
			.type(CitizenshipUpdateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.updateCitizenship(
										e.getIn().getBody(CitizenshipUpdateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/citizenships")
			.delete("/delete")
			.type(CitizenshipDeleteCommand.class)
			.route()
			.process(new AuthProcess("PARTY_DELETE"))
			.process(e->{
				
				CitizenshipDeleteCommand command = e.getIn().getBody(CitizenshipDeleteCommand.class);
				service.deleteCitizenship(command);
				e.getMessage().setBody(ResponseBuilder.success(command));
			})
			.endRest();
	}
}
