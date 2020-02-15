package com.sam.demo.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
	private String companyName;
	private String companyEmail;
	private String companyType;
	private String companyAddress;
	private String password;
	private String confirmPassword;
	private String companyQuestion;
	private String companyAnswer;
	
	 @OneToMany(mappedBy = "companyRegistration"
//			 ,
//			 cascade = CascadeType.ALL,
//	            fetch = FetchType.EAGER,
//	            orphanRemoval = true
	            )
	 private List<JobRegister> jobs = new ArrayList<>();
	
}
