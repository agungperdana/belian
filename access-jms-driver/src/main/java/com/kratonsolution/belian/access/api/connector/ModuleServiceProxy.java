package com.kratonsolution.belian.access.api.connector;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.access.api.ModuleData;
import com.kratonsolution.belian.access.api.ModuleRouteName;
import com.kratonsolution.belian.access.api.application.ModuleCreateCommand;
import com.kratonsolution.belian.access.api.application.ModuleDeleteCommand;
import com.kratonsolution.belian.access.api.application.ModuleFilter;
import com.kratonsolution.belian.access.api.application.ModuleService;
import com.kratonsolution.belian.access.api.application.ModuleUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
@SuppressWarnings("unchecked")
public class ModuleServiceProxy implements ModuleService {

	@Autowired
	private ProducerTemplate producer;
	
	@Override
	public ModuleData create(@NonNull ModuleCreateCommand command) {
		return producer.requestBody(ModuleRouteName.CREATE, command, ModuleData.class);
	}

	@Override
	public ModuleData update(@NonNull ModuleUpdateCommand command) {
		return producer.requestBody(ModuleRouteName.UPDATE, command, ModuleData.class);
	}

	@Override
	public ModuleData delete(@NonNull ModuleDeleteCommand command) {
		return producer.requestBody(ModuleRouteName.DELETE, command, ModuleData.class);
	}

	@Override
	public ModuleData getByCode(@NonNull String code) {
		return producer.requestBody(ModuleRouteName.BY_CODE, code, ModuleData.class);
	}

	@Override
	public List<ModuleData> getAllModules() {
		return producer.requestBody(ModuleRouteName.ALL_MODULES, null, List.class);
	}

	@Override
	public List<ModuleData> getAllModules(int page, int size) {
		return producer.requestBody(ModuleRouteName.ALL_MODULES_PAGING, new Object[] {page, size}, List.class);
	}

	@Override
	public List<ModuleData> getAllModules(@NonNull ModuleFilter filter, int page, int size) {
		return producer.requestBody(ModuleRouteName.ALL_MODULES_FILTER, new Object[] {filter, page, size}, List.class);
	}

	@Override
	public int count() {
		return producer.requestBody(ModuleRouteName.COUNT, null, Integer.class);
	}

	@Override
	public int count(@NonNull ModuleFilter filter) {
		return producer.requestBody(ModuleRouteName.COUNT_FILTER, filter,Integer.class);
	}

	@Override
	public List<ModuleData> getAllModules(@lombok.NonNull ModuleFilter filter) {
		// TODO Auto-generated method stub
		return getAllModules(filter, filter.getPage(), filter.getSize());
	}
}
