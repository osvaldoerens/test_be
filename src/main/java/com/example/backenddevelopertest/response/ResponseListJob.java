package com.example.backenddevelopertest.response;

import java.util.List;

import com.example.backenddevelopertest.model.JobModel;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat
public class ResponseListJob {

	private String status;
	private String respCode;
	private List<JobModel> data;

	
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
	public List<JobModel> getData() {
		return data;
	}

	public void setData(List<JobModel> data) {
		this.data = data;
	}

	

}
