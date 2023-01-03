package com.kratonsolution.belian.auth.repository;

import com.kratonsolution.belian.auth.model.AccessModule;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccessModuleRepository extends JpaRepository<AccessModule, String> {

    public Optional<AccessModule> findOneByName(@NonNull String name);
}
