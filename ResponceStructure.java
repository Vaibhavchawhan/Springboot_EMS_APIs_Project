package com.qsp.springboot_employee_management_system.util;

public class ResponceStructure<T> {
	
	 private String massage;
	 private int status;
	 private T data;
	/**
	 * @return the massage
	 */
	public String getMassage() {
		return massage;
	}
	/**
	 * @param massage the massage to set
	 */
	public void setMassage(String massage) {
		this.massage = massage;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponceStructure [massage=" + massage + ", status=" + status + ", data=" + data + "]";
	}
	 
	 
}
