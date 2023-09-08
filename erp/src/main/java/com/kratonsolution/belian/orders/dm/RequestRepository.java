
package com.kratonsolution.belian.orders.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface RequestRepository extends JpaRepository<Request, String>
{
	@Query("FROM Request req WHERE req.originator.id IN(:companys) ORDER BY req.entryDate DESC ")
	public List<Request> findAll(Pageable pageable,@Param("companys")List<String> companys);
	
	@Query("SELECT COUNT(req) FROM Request req WHERE req.originator.id IN(:companys)")
	public Long count(@Param("companys")List<String> companys);
	
	@Query("FROM Request req WHERE "
			+ "req.originator.id IN(:companys) "
			+ "AND (req.originator.value LIKE :key "
			+ "OR req.responding.value LIKE :key) "
			+ "ORDER BY req.entryDate DESC ")
	public List<Request> findAll(Pageable pageable,@Param("companys")List<String> companys,@Param("key")String key);
	
	@Query("SELECT COUNT(req) FROM Request req WHERE "
			+ "req.originator.id IN(:companys) "
			+ "AND (req.originator.value LIKE :key "
			+ "OR req.responding.value LIKE :key) ")
	public Long count(@Param("companys")List<String> companys,@Param("key")String key);
	
	@Query("SELECT DISTINCT(role.request) FROM RequestRole role WHERE "
			+ "role.request.originator.id =:origin "
			+ "AND role.request.responding.id =:respon "
			+ "AND role.request.closed = false "
			+ "AND role.type = 'APPROVER' "
			+ "AND role.approverStatus = 'ACCEPTED' "
			+ "ORDER BY role.request.entryDate DESC ")
	public List<Request> findAllUnclosed(@Param("origin")String origin,@Param("respon")String responding);
}
