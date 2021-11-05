package com.kratonsolution.belian.access.user.impl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.access.user.impl.model.User;

import lombok.NonNull;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0
 */
public interface UserRepository extends JpaRepository<User, String>
{	
    public Optional<User> findOneByName(@NonNull String name);
    
    public Optional<User> findOneByEmail(@NonNull String email);
    
    @Query("SELECT COUNT(usr) FROM User usr WHERE usr.name LIKE ?1 OR usr.email LIKE ?1")
    public Long count(@NonNull String key);
    
    @Query("FROM User usr WHERE usr.name LIKE ?1 OR usr.email LIKE ?1 ORDER BY usr.name, usr.email ASC")
    public List<User> findAll(@NonNull String key, Pageable pageable);
}