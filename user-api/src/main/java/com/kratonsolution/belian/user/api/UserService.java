package com.kratonsolution.belian.user.api;

import java.util.List;

public interface UserService {

    public User getOne(String id);

    public List<User> findAll();

    public int size();

    public List<User> findAll(int pageIndex,int pageSize);

    public void add(User user);

    public void edit(User user);

    public void delete(String id);

    public void changePassword(String id, String newPassword, String renewPassword);
}
