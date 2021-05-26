package com.kratonsolution.belian.access.impl.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.access.impl.model.User;

import lombok.NonNull;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface UserRepository extends JpaRepository<User, String>
{	
    public Optional<User> findOneByName(@NonNull String name);
    
    public Optional<User> findOneByEmail(@NonNull String email);
    
    @Query("SELECT COUNT(usr) FROM User usr WHERE usr.name LIKE ?1 OR usr.email LIKE ?1")
    public Long count(@NonNull String key);
}