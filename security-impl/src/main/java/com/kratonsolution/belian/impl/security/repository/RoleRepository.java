package com.kratonsolution.belian.impl.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.impl.security.model.Role;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public interface RoleRepository extends JpaRepository<Role, String> {
 
    public Optional<Role> findOneByCode(@NonNull String code);
    
    @Query("SELECT COUNT(role) FROM Role role WHERE role.code LIKE ?1 OR role.name LIKE ?1")
    public Long count(@NonNull String key);
}
