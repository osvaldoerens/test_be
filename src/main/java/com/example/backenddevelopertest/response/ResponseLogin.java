package com.example.backenddevelopertest.response;

import com.example.backenddevelopertest.model.LoginModel;

public class ResponseLogin {
	
	String Status;
	String Message;	
	String RespCode;	
	LoginModel logins;
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public String getRespCode() {
		return RespCode;
	}
	public void setRespCode(String respCode) {
		RespCode = respCode;
	}
	public LoginModel getLogins() {
		return logins;
	}
	public void setLogins(LoginModel logins) {
		this.logins = logins;
	}
	
}
