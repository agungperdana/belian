/**
 * 
 */
package com.kratonsolution.belian.education.dm;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 */
public interface StudyRoomRepository extends JpaRepository<StudyRoom, String>
{
	@Query("FROM StudyRoom room WHERE "
			+ "room.room.id =:room "
			+ "AND room.period.id =:period "
			+ "AND room.day.id =:day "
			+ "AND room.time.id =:time "
			+ "AND room.course.id =:course "
			+ "AND room.organization.id =:company ")
	public StudyRoom findOne(@Param("company")String company,@Param("room")String room,
							 @Param("period")String period,
							 @Param("day")String day,@Param("time")String time,
							 @Param("course")String course);

	@Query("FROM StudyRoom room WHERE "
			+ "room.organization.id IN(:company) "
			+ "AND room.room.name LIKE %:key% "
			+ "ORDER BY room.room.name ASC ")
	public List<StudyRoom> findAll(Pageable pageable,@Param("company")List<String> company,@Param("key")String key);
	
	@Query("SELECT COUNT(room) FROM StudyRoom room WHERE "
			+ "room.organization.id IN(:company) "
			+ "AND room.room.name LIKE %:key% ")
	public Long count(@Param("company")List<String> company,@Param("key")String key);
	
	@Query("FROM StudyRoom room WHERE "
			+ "room.organization.id IN(:company) "
			+ "ORDER BY room.room.name ASC ")
	public List<StudyRoom> findAll(Pageable pageable,@Param("company")List<String> company);
	
	@Query("SELECT COUNT(room) FROM StudyRoom room WHERE "
			+ "room.organization.id IN(:company) ")
	public Long count(@Param("company")List<String> company);
	
	@Query("FROM StudyRoom room WHERE "
			+ "room.organization.id IN(:company) "
			+ "AND room.period.id =:period "
			+ "ORDER BY room.room.name ASC ")
	public List<StudyRoom> findAll(@Param("company")List<String> company,@Param("period")String period);
}
