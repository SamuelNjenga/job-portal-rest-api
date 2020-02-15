package com.sam.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.demo.model.FresherRegistration;
@Repository
public interface FresherRepository extends JpaRepository<FresherRegistration, Long>{

}
