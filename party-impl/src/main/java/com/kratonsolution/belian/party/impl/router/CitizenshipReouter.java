package com.kratonsolution.belian.party.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
import com.kratonsolution.belian.party.api.application.CitizenshipCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyRoleCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyRoleDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyRoleUpdateCommand;
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
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.createPartyRole(
										e.getIn().getBody(CitizenshipCreateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/citizenships")
			.put("/update")
			.type(PartyRoleUpdateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.updatePartyRole(
										e.getIn().getBody(PartyRoleUpdateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/citizenships")
			.delete("/delete")
			.type(PartyRoleDeleteCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				
				PartyRoleDeleteCommand command = e.getIn().getBody(PartyRoleDeleteCommand.class);
				service.deletePartyRole(command);
				e.getMessage().setBody(ResponseBuilder.success(command));
			})
			.endRest();
	}
}
