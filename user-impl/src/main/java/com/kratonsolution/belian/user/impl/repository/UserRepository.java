package com.kratonsolution.belian.user.impl.repository;

import com.kratonsolution.belian.user.impl.orm.User;
import com.kratonsolution.belian.user.impl.orm.UserSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 1.0.0
 */
public interface UserRepository extends JpaRepository<User, String>
{	
	@Query("SELECT user FROM User user WHERE user.userName = :email")
	public User findByEmail(@Param("email") String email);

	@Query("SELECT user.setting FROM User user WHERE user.id =:user ")
	public UserSetting findSetting(@Param("user")String user);
}