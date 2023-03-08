
package com.kratonsolution.belian.security.dm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kratonsolution.belian.global.dm.UserSetting;

/**
 * 
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface UserRepository extends JpaRepository<User, String>
{	
	@Query("SELECT user FROM User user WHERE user.userName = ?1")
	public User findByEmail(String email);
	
	@Query("SELECT user.setting FROM User user WHERE user.id =:user ")
	public UserSetting findSetting(@Param("user")String user);
}