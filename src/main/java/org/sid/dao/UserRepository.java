package org.sid.dao;


import org.sid.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select e from User e where e.name like :x")
	public Page<User> rechercher(@Param("x") String x,Pageable pageable);
}
