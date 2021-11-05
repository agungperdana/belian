package com.kratonsolution.belian.party.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
import com.kratonsolution.belian.party.api.application.PartyRelationshipCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyRelationshipDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyRelationshipUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Component
public class PartyRelationshipReouter extends RouteBuilder {

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
			.path("/partys/relationships")
			.post("/create")
			.type(PartyRelationshipCreateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.createPartyRelationship(
										e.getIn().getBody(PartyRelationshipCreateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/relationships")
			.put("/update")
			.type(PartyRelationshipUpdateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.updatePartyRelationship(
										e.getIn().getBody(PartyRelationshipUpdateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/relationships")
			.delete("/delete")
			.type(PartyRelationshipDeleteCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				
				PartyRelationshipDeleteCommand command = e.getIn().getBody(PartyRelationshipDeleteCommand.class);
				service.deletePartyRelationship(command);
				e.getMessage().setBody(ResponseBuilder.success(command));
			})
			.endRest();
	}
}
