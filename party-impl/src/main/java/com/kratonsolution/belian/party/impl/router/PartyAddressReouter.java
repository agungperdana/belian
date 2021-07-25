package com.kratonsolution.belian.party.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
import com.kratonsolution.belian.party.api.application.AddressCreateCommand;
import com.kratonsolution.belian.party.api.application.AddressDeleteCommand;
import com.kratonsolution.belian.party.api.application.AddressUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Component
public class PartyAddressReouter extends RouteBuilder {

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
			.path("/partys/addresses")
			.post("/create")
			.type(AddressCreateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.createAddress(
										e.getIn().getBody(AddressCreateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/addresses")
			.put("/update")
			.type(AddressUpdateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.updateAddress(
										e.getIn().getBody(AddressUpdateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/addresses")
			.delete("/delete")
			.type(AddressDeleteCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				
				AddressDeleteCommand command = e.getIn().getBody(AddressDeleteCommand.class);
				service.deleteAddress(command);
				e.getMessage().setBody(ResponseBuilder.success(command));
			})
			.endRest();
	}
}
