package com.kratonsolution.belian.access.module.impl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kratonsolution.belian.access.module.impl.model.Module;

import lombok.NonNull;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com 
 */
public interface ModuleRepository extends JpaRepository<Module, String> {
 
    public Optional<Module> findOneByCode(@NonNull String code);
    
    @Query("SELECT COUNT(mod) FROM Module mod WHERE mod.code LIKE ?1 OR mod.name LIKE ?1 OR mod.group LIKE ?1")
    public Long count(@NonNull String key);
    
    @Query("FROM Module mod WHERE mod.code LIKE ?1 OR "
    		+ "mod.name LIKE ?1 OR "
    		+ "mod.group LIKE ?1 "
    		+ "ORDER BY mod.code, mod.name ASC")
    public List<Module> getAll(@NonNull String key, PageRequest pr);
}
