package com.example.backenddevelopertest.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backenddevelopertest.model.LoginModel;
import com.example.backenddevelopertest.repository.LoginRepository;
import com.example.backenddevelopertest.request.RequestLogin;
import com.example.backenddevelopertest.response.ResponseLogin;
import com.example.backenddevelopertest.response.ResponseBodySave;
import com.example.backenddevelopertest.utils.JwtUtils;
import com.example.backenddevelopertest.utils.Utils;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	LoginRepository loginRepository;
	//addToken to user table
	public void addTokenToUser(LoginModel logins) {
		try {
			loginRepository.save(logins);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostMapping(value = "/saveuser", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseBodySave doSaveUser(@Valid @RequestBody LoginModel loginModel) 
			throws NoSuchAlgorithmException {
		
		ResponseBodySave responseBodySave = new ResponseBodySave();	
	    
		try {
			String password = Utils.getMD5(loginModel.getPassword_hash());
			loginModel.setPassword_hash(password);
			
			loginRepository.save(loginModel);
			
	        responseBodySave.setStatus("true");
	        responseBodySave.setMessage("Data Berhasil Ditambahkan");
	        responseBodySave.setRespCode("00");
			
		}catch (Exception e) {
			// TODO: handle exception
			responseBodySave.setStatus("Gagal");
            responseBodySave.setMessage("Gagal simpan data !!! " + e.getMessage());
            responseBodySave.setRespCode("99");
		}
		return responseBodySave;
	}
	
	//login
	@PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
	@ResponseBody
	public ResponseLogin doLogin(@Valid @RequestBody RequestLogin loginRequest) 
			throws NoSuchAlgorithmException {
		
		ResponseLogin response = new ResponseLogin();
		Optional<LoginModel> loginModel;
		loginModel = loginRepository.doLogin(loginRequest.getUsername(),
					Utils.getMD5(loginRequest.getPassword_hash()));
		
		if(loginModel.isPresent()) {
			
			LoginModel loginExist = loginModel.get();
		    JwtUtils jwtUtils = new JwtUtils();
		    loginExist.setAccesToken(jwtUtils.generateToken(loginExist));
			addTokenToUser(loginExist);
		
			response.setStatus("true");
			response.setMessage("Login Success");
			response.setRespCode("00");
			response.setLogins(loginExist);
			
		} else {
			
			response.setStatus("false");
			response.setMessage("Login Failed");
			response.setRespCode("01");
			response.setLogins(null);
			
		}
		
		return response;
		
	}
	
    
}
