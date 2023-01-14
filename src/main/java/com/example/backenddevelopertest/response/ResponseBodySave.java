package com.example.backenddevelopertest.response;

public class ResponseBodySave {

	String Status;
	String Message;	
	String RespCode;
	
	
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
	
	@Override
	public String toString() {
		return "ResponseBodySave [Status=" + Status + ", Message=" + Message + ", RespCode=" + RespCode + "]";
	}
}
