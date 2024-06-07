package com.kratonsolution.belian.access.user.impl.repository;

import com.kratonsolution.belian.access.user.impl.orm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public interface UserRepository extends JpaRepository<User, String>
{	
	@Query("SELECT user FROM User user WHERE user.userName = ?1")
	public User findByEmail(String email);
//
//	@Query("SELECT user.setting FROM User user WHERE user.id =:user ")
//	public UserSetting findSetting(@Param("user")String user);
}