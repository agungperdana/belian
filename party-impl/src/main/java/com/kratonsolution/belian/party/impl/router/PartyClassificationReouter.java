package com.kratonsolution.belian.party.impl.router;

import java.util.Optional;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
import com.kratonsolution.belian.party.api.PartyClassificationData;
import com.kratonsolution.belian.party.api.PartyData;
import com.kratonsolution.belian.party.api.application.PartyClassificationCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyClassificationDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyClassificationUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyService;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Component
public class PartyClassificationReouter extends RouteBuilder {

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
			.path("/partys/classifications/get")
			.get("/{partyCode}/{classId}")
			.type(PartyClassificationCreateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				
				PartyData obj = service.getByCode(e.getIn().getHeader("partyCode", String.class));
				if(obj != null) {
				
					Optional<PartyClassificationData> target = obj.getPartyClassifications()
														.stream()
														.filter(p -> p.getId().equals(
																e.getIn().getHeader("classId", String.class)))
														.findFirst();
					if(target.isPresent()) {
						
						e.getMessage().setBody(ResponseBuilder.success(target.get()));
					}
				}				
			})
			.endRest();
		
		rest()
			.path("/partys/classifications")
			.post("/create")
			.type(PartyClassificationCreateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.createPartyClassification(
										e.getIn().getBody(PartyClassificationCreateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/classifications")
			.put("/update")
			.type(PartyClassificationUpdateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.updatePartyClassification(
										e.getIn().getBody(PartyClassificationUpdateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/classifications")
			.delete("/delete")
			.type(PartyClassificationDeleteCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.deletePartyClassification(
										e.getIn().getBody(PartyClassificationDeleteCommand.class))));
			})
			.endRest();
	}
}
