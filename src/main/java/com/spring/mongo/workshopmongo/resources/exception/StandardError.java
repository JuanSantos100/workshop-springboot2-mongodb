package com.spring.mongo.workshopmongo.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long timeStamp;
	private Integer status;
	private String erro;
	private String message;
	private String path;
	
	public StandardError() {
		
	}
	
	

	public StandardError(Long timeStamp, Integer status, String erro, String message, String path) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.erro = erro;
		this.message = message;
		this.path = path;
	}



	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
