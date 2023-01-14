package com.example.backenddevelopertest.response;

import com.example.backenddevelopertest.model.JobModel;

public class ResponseDetailJob {
	
	private String status;
	private String respCode;
	private JobModel data;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public JobModel getData() {
		return data;
	}
	public void setData(JobModel data) {
		this.data = data;
	}

	
}
