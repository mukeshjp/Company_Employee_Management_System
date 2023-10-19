package com.spring.empManagement.EmployeeManagement.responsestructure;

public class ResponseStructure<T> {
	
	private String messege;
	private int status;
	private T data;
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}

}
