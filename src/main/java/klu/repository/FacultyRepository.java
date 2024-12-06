package klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import klu.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	
	@Query("select count(F) from Faculty F where F.id=:id")
	public Long getFID(@Param("id") Long id);
}
