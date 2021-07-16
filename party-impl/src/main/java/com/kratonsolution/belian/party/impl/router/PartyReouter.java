package com.kratonsolution.belian.party.impl.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kratonsolution.belian.camel.AuthProcess;
import com.kratonsolution.belian.camel.ResponseBuilder;
import com.kratonsolution.belian.party.api.PartyRouteName;
import com.kratonsolution.belian.party.api.application.AddressCreateCommand;
import com.kratonsolution.belian.party.api.application.AddressDeleteCommand;
import com.kratonsolution.belian.party.api.application.AddressUpdateCommand;
import com.kratonsolution.belian.party.api.application.ContactCreateCommand;
import com.kratonsolution.belian.party.api.application.ContactDeleteCommand;
import com.kratonsolution.belian.party.api.application.ContactUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyClassificationCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyClassificationDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyClassificationUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyFilter;
import com.kratonsolution.belian.party.api.application.PartyRelationshipCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyRelationshipDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyRelationshipUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyRoleCreateCommand;
import com.kratonsolution.belian.party.api.application.PartyRoleDeleteCommand;
import com.kratonsolution.belian.party.api.application.PartyRoleUpdateCommand;
import com.kratonsolution.belian.party.api.application.PartyService;
import com.kratonsolution.belian.party.api.application.PartyUpdateCommand;
import com.kratonsolution.belian.party.api.model.PartyType;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Component
public class PartyReouter extends RouteBuilder {

	@Autowired
	private PartyService service;

	@Override
	public void configure() throws Exception {

		initJMS();
		initRest();
	}

	private void initJMS() {

		from(PartyRouteName.CREATE).transacted().process(e->
		e.getMessage().setBody(service.create(e.getIn().getBody(PartyCreateCommand.class))));

		from(PartyRouteName.UPDATE).transacted().process(e->
		e.getMessage().setBody(service.update(e.getIn().getBody(PartyUpdateCommand.class))));

		from(PartyRouteName.DELETE).transacted().process(e->
		e.getMessage().setBody(service.delete(e.getIn().getBody(PartyDeleteCommand.class))));

		from(PartyRouteName.COUNT).setBody().constant(service.count());

		from(PartyRouteName.COUNT_WITH_TYPE).process(e->
		e.getMessage().setBody(service.count(e.getIn().getBody(PartyType.class))));

		from(PartyRouteName.COUNT_WITH_FILTER).process(e->
		e.getMessage().setBody(service.count(e.getIn().getBody(PartyFilter.class))));

		from(PartyRouteName.BY_ID).process(e->
		e.getMessage().setBody(service.getById(e.getIn().getBody(String.class))));

		from(PartyRouteName.BY_CODE).process(e->
		e.getMessage().setBody(service.getByCode(e.getIn().getBody(String.class))));

		from(PartyRouteName.ALL_PARTYS).process(e->
		e.getMessage().setBody(service.getAllPartys()));

		from(PartyRouteName.ALL_PARTYS_PAGING).process(e->{

			Integer[] params = e.getIn().getBody(Integer[].class);
			e.getMessage().setBody(service.getAllPartys(params[0], params[1]));
		});


		from(PartyRouteName.ALL_PARTYS_TYPE).process(e->
		e.getMessage().setBody(service.getAllPartys(e.getIn().getBody(PartyType.class))));

		from(PartyRouteName.ALL_PARTYS_TYPE_PAGING).process(e->{

			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(
					service.getAllPartys((PartyType)params[0], 
							(Integer)params[1], (Integer)params[2]));
		});

		from(PartyRouteName.ALL_PARTYS_FILTER_PAGING).process(e->{

			Object[] params = e.getIn().getBody(Object[].class);
			e.getMessage().setBody(
					service.getAllPartys((PartyFilter)params[0], 
							(Integer)params[1], (Integer)params[2]));
		});

		from(PartyRouteName.CREATE_ADDRESS).transacted().process(e->
		e.getMessage().setBody(service.createAddress(e.getIn().getBody(AddressCreateCommand.class))));

		from(PartyRouteName.UPDATE_ADDRESS).transacted().process(e->
		e.getMessage().setBody(service.updateAddress(e.getIn().getBody(AddressUpdateCommand.class))));

		from(PartyRouteName.DELETE_ADDRESS).transacted().process(e->
		service.deleteAddress(e.getIn().getBody(AddressDeleteCommand.class)));

		from(PartyRouteName.CREATE_CONTACT).transacted().process(e->
		e.getMessage().setBody(service.createContact(e.getIn().getBody(ContactCreateCommand.class))));

		from(PartyRouteName.UPDATE_CONTACT).transacted().process(e->
		e.getMessage().setBody(service.updateContact(e.getIn().getBody(ContactUpdateCommand.class))));

		from(PartyRouteName.DELETE_CONTACT).transacted().process(e->
		service.deleteContact(e.getIn().getBody(ContactDeleteCommand.class)));

		from(PartyRouteName.CREATE_ROLE).transacted().process(e->
		e.getMessage().setBody(service.createPartyRole(e.getIn().getBody(PartyRoleCreateCommand.class))));

		from(PartyRouteName.UPDATE_ROLE).transacted().process(e->
		e.getMessage().setBody(service.updatePartyRole(e.getIn().getBody(PartyRoleUpdateCommand.class))));

		from(PartyRouteName.DELETE_ROLE).transacted().process(e->
		service.deletePartyRole(e.getIn().getBody(PartyRoleDeleteCommand.class)));

		from(PartyRouteName.CREATE_RELATIONSHIP).transacted().process(e->
		e.getMessage().setBody(service.createPartyRelationship(e.getIn().getBody(PartyRelationshipCreateCommand.class))));

		from(PartyRouteName.UPDATE_RELATIONSHIP).transacted().process(e->
		e.getMessage().setBody(service.updatePartyRelationship(e.getIn().getBody(PartyRelationshipUpdateCommand.class))));

		from(PartyRouteName.DELETE_RELATIONSHIP).transacted().process(e->
		service.deletePartyRelationship(e.getIn().getBody(PartyRelationshipDeleteCommand.class)));

		from(PartyRouteName.CREATE_CLASSIFICATION).transacted().process(e->
		e.getMessage().setBody(service.createPartyClassification(e.getIn().getBody(PartyClassificationCreateCommand.class))));

		from(PartyRouteName.UPDATE_CLASSIFICATION).transacted().process(e->
		e.getMessage().setBody(service.updatePartyClassification(e.getIn().getBody(PartyClassificationUpdateCommand.class))));

		from(PartyRouteName.DELETE_CLASSIFICATION).transacted().process(e->
		service.deletePartyClassification(e.getIn().getBody(PartyClassificationDeleteCommand.class)));
	}
	
	private void initRest() {
		
		rest()
			.path("/partys/get")
			.get("/{code}")
			.route()
			.process(new AuthProcess("PARTY_READ"))
			.process(e->{
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.getByCode(e.getIn().getHeader("code", String.class))));
			})
			.endRest();
		
		rest()
			.path("/partys/all-partys")
			.get("/{page}/{size}")
			.route()
			.process(new AuthProcess("PARTY_READ"))
			.process(e->{
				
				PartyFilter filter = new PartyFilter();
				filter.setPage(e.getIn().getHeader("page", Integer.class));
				filter.setSize(e.getIn().getHeader("size", Integer.class));
				
				e.getMessage().setBody(ResponseBuilder.success(service.getAllPartys(filter)));
			})
			.endRest();
		
		rest()
			.path("/partys/all-partys")
			.get("/{page}/{size}/{key}")
			.route()
			.process(new AuthProcess("PARTY_READ"))
			.process(e->{
				
				PartyFilter filter = new PartyFilter();
				filter.setKey(e.getIn().getHeader("key", String.class));
				filter.setPage(e.getIn().getHeader("page", Integer.class));
				filter.setSize(e.getIn().getHeader("size", Integer.class));
				
				e.getMessage().setBody(ResponseBuilder.success(service.getAllPartys(filter)));
			})
			.endRest();
		
		rest()
			.path("/partys")
			.post("/create")
			.type(PartyCreateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_ADD"))
			.process(e->{
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.create(e.getIn().getBody(PartyCreateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys")
			.put("/update")
			.type(PartyUpdateCommand.class)
			.route()
			.process(new AuthProcess("PARTY_EDIT"))
			.process(e->{
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.update(e.getIn().getBody(PartyUpdateCommand.class))));
			})
			.endRest();
		
		rest()
			.path("/partys")
			.delete("/delete")
			.type(PartyDeleteCommand.class)
			.route()
			.process(new AuthProcess("PARTY_DELETE"))
			.process(e->{
				
				e.getMessage().setBody(
						ResponseBuilder.success(
								service.delete(e.getIn().getBody(PartyDeleteCommand.class))));
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
