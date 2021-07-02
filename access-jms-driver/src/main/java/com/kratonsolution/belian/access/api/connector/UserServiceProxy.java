package com.kratonsolution.belian.access.api.connector;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.kratonsolution.belian.access.api.UserData;
import com.kratonsolution.belian.access.api.UserFilter;
import com.kratonsolution.belian.access.api.UserRouteName;
import com.kratonsolution.belian.access.api.application.ChangePasswordCommand;
import com.kratonsolution.belian.access.api.application.DeleteUserRoleCommand;
import com.kratonsolution.belian.access.api.application.RegisterNewUserRoleCommand;
import com.kratonsolution.belian.access.api.application.SignInCommand;
import com.kratonsolution.belian.access.api.application.UpdateUserRoleCommand;
import com.kratonsolution.belian.access.api.application.UserCreateCommand;
import com.kratonsolution.belian.access.api.application.UserDeleteCommand;
import com.kratonsolution.belian.access.api.application.UserService;
import com.kratonsolution.belian.access.api.application.UserUpdateCommand;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @sinch 2.0
 */
@Service
@SuppressWarnings("unchecked")
public class UserServiceProxy implements UserService {

	@Autowired
	private ProducerTemplate producer;
	
	@Override
	public UserData create(@NonNull UserCreateCommand command) {
		return producer.requestBody(UserRouteName.CREATE, command, UserData.class);
	}

	@Override
	public UserData update(@NonNull UserUpdateCommand command) {
		return producer.requestBody(UserRouteName.UPDATE, command, UserData.class);
	}

	@Override
	public UserData delete(@NonNull UserDeleteCommand command) {
		return producer.requestBody(UserRouteName.DELETE, command, UserData.class);
	}

	@Override
	public UserData changePassword(@NonNull ChangePasswordCommand command) {
		return producer.requestBody(UserRouteName.CHANGE_PASSWORD, command, UserData.class);
	}

	@Override
	public UserData getByName(@NonNull String name) {
		return producer.requestBody(UserRouteName.BY_NAME, name, UserData.class);
	}

	@Override
	public UserData getByEmail(@NonNull String email) {
		return producer.requestBody(UserRouteName.BY_EMAIL, email, UserData.class);
	}

	@Override
	public List<UserData> getAllUsers() {
		return producer.requestBody(UserRouteName.ALL_USERS, null, List.class);
	}

	@Override
	public List<UserData> getAllUsers(int page, int size) {
		return producer.requestBody(UserRouteName.ALL_USERS_PAGING, new Object[] {page, size}, List.class);
	}

	@Override
	public List<UserData> getAllUsers(@NonNull UserFilter filter, int page, int size) {
		return producer.requestBody(UserRouteName.ALL_USERS_FILTER, new Object[] {filter, page, size}, List.class);
	}

	@Override
	public int count() {
		return producer.requestBody(UserRouteName.COUNT, null, Integer.class);
	}

	@Override
	public int count(@NonNull UserFilter filter) {
		return producer.requestBody(UserRouteName.COUNT_FILTER, filter, Integer.class);
	}

	@Override
	public UserData addNewUserRole(@NonNull RegisterNewUserRoleCommand command) {
		return producer.requestBody(UserRouteName.ADD_ROLE, command, UserData.class);
	}

	@Override
	public UserData updateUserRole(@NonNull UpdateUserRoleCommand command) {
		return producer.requestBody(UserRouteName.UPDATE_ROLE, command, UserData.class);
	}

	@Override
	public UserData deleteUserRole(@NonNull DeleteUserRoleCommand command) {
		return producer.requestBody(UserRouteName.DELETE_ROLE, command, UserData.class);
	}

	@Override
	public UserData signIn(@lombok.NonNull SignInCommand command) {
		// TODO Auto-generated method stub
		return null;
	}

}
