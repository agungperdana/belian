package com.kratonsolution.belian.user.api;

import lombok.NonNull;

import java.util.List;

public interface UserService {

    public UserData getOne(String email);

    public List<UserData> findAll();

    public int size();

    public List<UserData> findAll(int offset,int limit);

    public void add(UserCreateCommand command);

    public void edit(UserUpdateCommand command);

    public void delete(UserDeleteCommand command);

    public void changePassword(@NonNull ChangePasswordCommand command);
}
