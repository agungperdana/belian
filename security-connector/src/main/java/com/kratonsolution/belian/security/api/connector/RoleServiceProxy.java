package com.kratonsolution.belian.security.api.connector;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.security.api.RoleData;
import com.kratonsolution.belian.security.api.RoleRouteName;
import com.kratonsolution.belian.security.api.application.RoleCreateCommand;
import com.kratonsolution.belian.security.api.application.RoleDeleteCommand;
import com.kratonsolution.belian.security.api.application.RoleFilter;
import com.kratonsolution.belian.security.api.application.RoleService;
import com.kratonsolution.belian.security.api.application.RoleUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
@SuppressWarnings("unchecked")
public class RoleServiceProxy implements RoleService {

	@Autowired
	private ProducerTemplate producer;
	
	@Override
	public RoleData create(@NonNull RoleCreateCommand command) {
		return producer.requestBody(RoleRouteName.CREATE, command, RoleData.class);
	}

	@Override
	public RoleData update(@NonNull RoleUpdateCommand command) {
		return producer.requestBody(RoleRouteName.UPDATE, command, RoleData.class);
	}

	@Override
	public RoleData delete(@NonNull RoleDeleteCommand command) {
		return producer.requestBody(RoleRouteName.DELETE, command, RoleData.class);
	}

	@Override
	public RoleData getByCode(@NonNull String code) {
		return producer.requestBody(RoleRouteName.BY_CODE, code, RoleData.class);
	}

	@Override
	public List<RoleData> getAllRoles() {
		return producer.requestBody(RoleRouteName.ALL_ROLES, null, List.class);
	}

	@Override
	public List<RoleData> getAllRoles(int page, int size) {
		return producer.requestBody(RoleRouteName.ALL_ROLES_PAGING, new Object[] {page, size}, List.class);
	}

	@Override
	public List<RoleData> getAllRoles(@NonNull RoleFilter filter, int page, int size) {
		return producer.requestBody(RoleRouteName.ALL_ROLES_FILTER, new Object[] {filter, page, size}, List.class);
	}

	@Override
	public int count() {
		return producer.requestBody(RoleRouteName.COUNT, null, Integer.class);
	}

	@Override
	public int count(@NonNull RoleFilter filter) {
		return producer.requestBody(RoleRouteName.COUNT_FILTER, filter, Integer.class);
	}

}
