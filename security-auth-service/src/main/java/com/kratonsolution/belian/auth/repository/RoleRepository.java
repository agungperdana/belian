package com.kratonsolution.belian.auth.repository;

import com.kratonsolution.belian.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
