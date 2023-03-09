package com.kratonsolution.belian.security.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface ModuleRepository extends JpaRepository<Module, String>
{
	public Module getOneByCode(String code);
	
	public Module getOneByName(String name);
	
	@Query("FROM Module mod WHERE "
			+ "mod.code LIKE %:key% "
			+ "OR mod.name LIKE %:key% "
			+ "OR mod.group LIKE %:key% "
			+ "ORDER BY mod.code ASC,mod.name ASC,mod.group ASC")
	public List<Module> findAll(Pageable pageable, @Param("key")String key);
	
	@Query("SELECT COUNT(mod) FROM Module mod WHERE "
			+ "mod.code LIKE %:key% "
			+ "OR mod.name LIKE %:key% "
			+ "OR mod.group LIKE %:key% ")
	public Long count(@Param("key")String key);
}
