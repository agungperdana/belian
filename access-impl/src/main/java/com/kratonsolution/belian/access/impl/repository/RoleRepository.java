package com.kratonsolution.belian.access.impl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.access.impl.model.Role;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public interface RoleRepository extends JpaRepository<Role, String> {
 
    public Optional<Role> findOneByCode(@NonNull String code);
    
    @Query("SELECT COUNT(role) FROM Role role WHERE role.code LIKE ?1 OR role.name LIKE ?1")
    public Long count(@NonNull String key);
    
    @Query("FROM Role role WHERE role.code LIKE ?1 OR "
    		+ "role.name LIKE ?1 "
    		+ "ORDER BY role.code, role.name ASC ")
    public List<Role> getAll(@NonNull String key, PageRequest pr);
}
