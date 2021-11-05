package com.kratonsolution.belian.access.role.impl.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kratonsolution.belian.access.role.impl.model.Role;
import com.kratonsolution.belian.access.role.impl.model.RoleModule;
import com.kratonsolution.belian.access.role.impl.repository.RoleRepository;
import com.kratonsolution.belian.common.application.EventSourceName;
import com.kratonsolution.belian.common.application.SystemEvent;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @version 2.0
 */
@Component
@Transactional
public class RoleSystemEventListener implements ApplicationListener<PayloadApplicationEvent<SystemEvent>> {

	@Autowired
	private RoleRepository repo;
	
	public void onApplicationEvent(PayloadApplicationEvent<SystemEvent> event) {

		SystemEvent obj = event.getPayload();
		
		if(obj != null && obj.getSource().equals(EventSourceName.ACCESS_MODULE)) {
			
			List<Role> roles = repo.findAll();
			
			if(obj.getAsString(SystemEvent.PAYLOAD_CODE).isPresent()) {

				if(obj.getType().equals(SystemEvent.ADD)) {

					roles.stream().forEach(role -> {

						role.getModules()
							.add(new RoleModule(role, 
												obj.getAsString(SystemEvent.PAYLOAD_CODE).get(), 
												obj.getAsString(SystemEvent.PAYLOAD_NAME).get(), 
												obj.getAsString("groip").get(), 
												false, false, false, false, false)); 

						repo.save(role);
					});
				}
				else if(obj.getType().equals(SystemEvent.UPDATE)) {
					
					roles.stream().forEach(role -> {
						
						Optional<RoleModule> opt = role.getModules()
													   .stream()
													   .filter(p -> p.getModuleCode()
															   		 .equals(obj.getAsString(SystemEvent.PAYLOAD_CODE).get()))
													   .findFirst();
						if(opt.isPresent()) {
							
							opt.get().setModuleName(obj.getAsString(SystemEvent.PAYLOAD_NAME).get());
							opt.get().setModuleGroup(obj.getAsString("groip").get());
							
							repo.save(role);
						}
					});
				}
				else {
					
					roles.stream().forEach(role -> {
						role.getModules()
						   .removeIf(p->p.getModuleCode().equals(obj.getAsString(SystemEvent.PAYLOAD_CODE).get()));
					});
				}
			}
		}
	}
}
