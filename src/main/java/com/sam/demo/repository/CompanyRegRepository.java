package com.sam.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sam.demo.model.CompanyRegistration;
@Repository
public interface CompanyRegRepository extends JpaRepository<CompanyRegistration, Long> {

}
