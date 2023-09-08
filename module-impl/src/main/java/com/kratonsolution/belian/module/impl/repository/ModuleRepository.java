package com.kratonsolution.belian.module.impl.repository;

import java.util.List;

import com.kratonsolution.belian.module.impl.orm.Module;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public interface ModuleRepository extends JpaRepository<Module, String>
{
    public Module findOneByCode(String code);

    public Module findOneByName(String name);

    @Query("FROM Module mdl WHERE "
            + "mdl.code LIKE :key "
            + "OR mdl.name LIKE :key "
            + "ORDER BY mdl.code ASC, mdl.name ASC, mdl.group ASC")
    public List<Module> findAll(Pageable pageable, @Param("key")String key);

    @Query("SELECT COUNT(mdl) FROM Module mdl WHERE "
            + "mdl.code LIKE :key "
            + "OR mdl.name LIKE :key ")
    public Long count(@Param("key")String key);
}
