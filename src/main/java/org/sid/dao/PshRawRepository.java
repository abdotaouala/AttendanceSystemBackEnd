package org.sid.dao;


import org.sid.entities.PshRaw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PshRawRepository extends JpaRepository<PshRaw, Long>{

	public Page<PshRaw> findByUserName(String name,Pageable pageable);
}
