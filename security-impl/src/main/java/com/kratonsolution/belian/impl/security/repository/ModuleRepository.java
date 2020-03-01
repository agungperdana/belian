package com.kratonsolution.belian.impl.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.impl.security.model.Module;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public interface ModuleRepository extends JpaRepository<Module, String> {
 
    public Optional<Module> findOneByCode(@NonNull String code);
    
    @Query("SELECT COUNT(mod) FROM Module mod WHERE mod.code LIKE ?1 OR mod.name LIKE ?1 OR mod.group LIKE ?1")
    public Long count(@NonNull String key);
}
