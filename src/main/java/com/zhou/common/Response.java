package com.zhou.common;

import java.util.List;

public class Response {
	protected int status;
	protected Object body;

	public Response(){}
	
	public Response(int status) {
		this.status = status;
	}
	public Response(int status, Object body) {
		this(status);
		this.body = body;
	}
	public Response(int status,List<Object> body){
		this.status = status;
		this.body = body;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
 
