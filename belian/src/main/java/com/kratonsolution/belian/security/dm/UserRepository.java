/**
 * 
 */
package com.kratonsolution.belian.security.dm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author agungdodiperdana
 *
 */
public interface UserRepository extends JpaRepository<User, String>
{
	@Query("SELECT user FROM User user WHERE user.name = ?1")
	public User findByName(String name);
	
	@Query("SELECT user FROM User user WHERE user.email = ?1")
	public User findByEmail(String email);
}
