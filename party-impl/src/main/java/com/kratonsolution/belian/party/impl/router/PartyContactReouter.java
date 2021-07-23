package com.kratonsolution.belian.party.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
import com.kratonsolution.belian.party.api.application.ContactCreateCommand;
import com.kratonsolution.belian.party.api.application.ContactDeleteCommand;
import com.kratonsolution.belian.party.api.application.ContactUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Component
public class PartyContactReouter extends RouteBuilder {

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
			.path("/partys/contacts")
			.post("/create")
			.type(ContactCreateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.createContact(
										e.getIn().getBody(ContactCreateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/contacts")
			.put("/update")
			.type(ContactUpdateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.updateContact(
										e.getIn().getBody(ContactUpdateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/contacts")
			.delete("/delete")
			.type(ContactDeleteCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				
				ContactDeleteCommand command = e.getIn().getBody(ContactDeleteCommand.class);
				service.deleteContact(command);
				e.getMessage().setBody(ResponseBuilder.success(command));
			})
			.endRest();
	}
}
