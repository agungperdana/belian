package com.kratonsolution.belian.access.role.driver.jms;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
@SuppressWarnings("unchecked")
public class RoleJmsDriver {

	@Autowired
	private ProducerTemplate producer;
	
	private Gson parser = new Gson();

	public RoleData create(@NonNull RoleCreateCommand command) {
		return parser.fromJson(producer.requestBody(RoleRouteName.CREATE, command, String.class), RoleData.class);
	}

	public RoleData update(@NonNull RoleUpdateCommand command) {
		return parser.fromJson(producer.requestBody(RoleRouteName.UPDATE, command, String.class), RoleData.class);
	}

	public RoleData delete(@NonNull RoleDeleteCommand command) {
		return parser.fromJson(producer.requestBody(RoleRouteName.DELETE, command, String.class), RoleData.class);
	}

	public RoleData getByCode(@NonNull String code) {
		return parser.fromJson(producer.requestBody(RoleRouteName.BY_CODE, code, String.class), RoleData.class);
	}

	public List<RoleData> getAllRoles() {
		return parser.fromJson(producer.requestBody(RoleRouteName.ALL_ROLES, null, String.class), List.class);
	}

	public List<RoleData> getAllRoles(int page, int size) {
		return parser.fromJson(producer.requestBody(RoleRouteName.ALL_ROLES_PAGING, new Object[] {page, size}, String.class), List.class);
	}

	public List<RoleData> getAllRoles(@NonNull RoleFilter filter, int page, int size) {
		return parser.fromJson(producer.requestBody(RoleRouteName.ALL_ROLES_FILTER, new Object[] {filter, page, size}, String.class), List.class);
	}

	public int count() {
		return producer.requestBody(RoleRouteName.COUNT, null, Integer.class);
	}

	public int count(@NonNull RoleFilter filter) {
		return producer.requestBody(RoleRouteName.COUNT_FILTER, filter, Integer.class);
	}

	public List<RoleData> getAllRoles(@lombok.NonNull RoleFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}
}
