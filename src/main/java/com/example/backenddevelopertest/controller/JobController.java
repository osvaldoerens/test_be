package com.example.backenddevelopertest.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.backenddevelopertest.model.JobModel;
import com.example.backenddevelopertest.model.LoginModel;
import com.example.backenddevelopertest.repository.LoginRepository;
import com.example.backenddevelopertest.response.ResponseDetailJob;
import com.example.backenddevelopertest.response.ResponseListJob;
import com.example.backenddevelopertest.utils.JwtUtils;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/job")
public class JobController {
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping(value = "/getjoblist",produces = "application/json")
	@ResponseBody
	public ResponseListJob doGetListJob(@RequestHeader (name = "Authorization") String token) 
			throws NoSuchAlgorithmException, StreamReadException, DatabindException, IOException {
		ResponseListJob response = new ResponseListJob();
		JwtUtils jwt = new JwtUtils();
		Optional<LoginModel> userLogin = loginRepository.findByAccesToken(token);
		
		if(userLogin.isPresent()) {
		
			Boolean isValid = jwt.validateToken(token, userLogin.get());
		
			if(isValid) {
				try {
					 
					 final String uri 			= "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
					 RestTemplate restTemplate  = new RestTemplate();
				     Object[] result 			= restTemplate.getForObject(uri, Object[].class);
				     List<JobModel> listData    = new ArrayList<>();
					 ObjectMapper mapper 	    = new ObjectMapper();
					 
					 for(Object job : result) {
					    	
						 byte[] json = mapper.writeValueAsBytes(job);
					     listData.add(mapper.readValue(json, JobModel.class));
						    
					 }
					 response.setStatus("success");
					 response.setRespCode("200");
					 response.setData(listData);
				}
				catch (Exception e) {
					 response.setStatus("failed");
					 response.setRespCode("999"+e.getMessage());
					 response.setData(new ArrayList<>());
				}
			} else {
				response.setStatus("failed");
				response.setRespCode("Invalid Token");
				response.setData(new ArrayList<>());
			}
			
		}
		else {
			response.setStatus("failed");
			response.setRespCode("Token tidak valid");
			response.setData(new ArrayList<>());
		}
		
		
		return response;
	}
	
	@GetMapping(value = "/getdetailjob",produces = "application/json")
	@ResponseBody
	public ResponseDetailJob doGetDetailJob(@RequestParam(required = true) String id, 
			@RequestHeader (name = "Authorization") String token) 
			throws NoSuchAlgorithmException, StreamReadException, DatabindException, IOException {
		ResponseDetailJob response = new ResponseDetailJob();
		
		JwtUtils jwt = new JwtUtils();
		Optional<LoginModel> userLogin = loginRepository.findByAccesToken(token);
		
		if(userLogin.isPresent()) {
			
			Boolean isValid = jwt.validateToken(token, userLogin.get());
		
			if(isValid) {
				try {
					
					 final String uri 			= "http://dev3.dansmultipro.co.id/api/recruitment/positions/"+id;
					 RestTemplate restTemplate  = new RestTemplate();
				     JobModel jobDetail 			= restTemplate.getForObject(uri, JobModel.class);
				     
					 response.setStatus("success");
					 response.setRespCode("200");
					 response.setData(jobDetail);
				}
				catch (Exception e) {
					 response.setStatus("failed");
					 response.setRespCode("999" +e.getMessage());
					 response.setData(null);
				}
			} else {
				response.setStatus("failed");
				response.setRespCode("Invalid Token");
				response.setData(null);
			}
			
		}
		else {
			response.setStatus("failed");
			response.setRespCode("Token tidak valid");
			response.setData(null);
		}
		return response;
	}

}
