package com.sam.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.sam.demo.model.JobRegister;
@Repository
public interface JobRegRepository extends JpaRepository<JobRegister, Long>{

	@Query("select j from JobRegister j where j.location like %?1")
	List<JobRegister> findByNameEndsWith( String name);
	
}
