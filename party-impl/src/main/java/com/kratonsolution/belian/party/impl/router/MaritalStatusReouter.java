package com.kratonsolution.belian.party.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
import com.kratonsolution.belian.party.api.application.MaritalStatusCreateCommand;
import com.kratonsolution.belian.party.api.application.MaritalStatusDeleteCommand;
import com.kratonsolution.belian.party.api.application.MaritalStatusUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Component
public class MaritalStatusReouter extends RouteBuilder {

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
			.path("/partys/marital-statuses")
			.post("/create")
			.type(MaritalStatusCreateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.createMaritalStatus(
										e.getIn().getBody(MaritalStatusCreateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/marital-statuses")
			.put("/update")
			.type(MaritalStatusUpdateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.updateMaritalStatus(
										e.getIn().getBody(MaritalStatusUpdateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/marital-statuses")
			.delete("/delete")
			.type(MaritalStatusDeleteCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				
				MaritalStatusDeleteCommand command = e.getIn().getBody(MaritalStatusDeleteCommand.class);
				service.deleteMaritalStatus(command);
				e.getMessage().setBody(ResponseBuilder.success(command));
			})
			.endRest();
	}
}
