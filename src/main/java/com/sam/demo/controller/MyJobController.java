package com.sam.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sam.demo.model.JobRegister;
import com.sam.demo.repository.JobRegRepository;

@RestController
public class MyJobController {
	@Autowired
	JobRegRepository jobRegRepo;
//	private static final Logger logger = Logger.getLogger(MyJobController.class.getName());

	@GetMapping("/showCitiesEnding")
	public List<List<JobRegister>> findByNameEndsWith( @RequestParam String name) {
        List<JobRegister> jobs = jobRegRepo.findByNameEndsWith(name);
        return Arrays.asList(jobs);
    }

	 @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
//	        logger.info(String.format("File name '%s' uploaded successfully.", file.getOriginalFilename()));
	     File conFile = new File("C:\\store\\" +file.getOriginalFilename());
	     conFile.createNewFile();
	     FileOutputStream fout = new FileOutputStream(conFile);
	     fout.write(file.getBytes());
	     fout.close();
		 return new ResponseEntity<>("File is uploaded successfully",HttpStatus.OK);
	    }
	
}
