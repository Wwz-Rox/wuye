package org.edu.common.json;

public class JsonResult<T> {
	private String status;
	private String message;
	private T data;
	
	public JsonResult(String status,String message,T data) {
		this.status=status;
		this.message=message;
		this.data=data;
	}
	public JsonResult(String status,String message) {
		this.status=status;
		this.message=message;
	}
	
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
