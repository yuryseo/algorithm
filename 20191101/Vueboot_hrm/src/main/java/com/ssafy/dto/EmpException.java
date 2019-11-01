package com.ssafy.dto;

public class EmpException extends RuntimeException {
	public EmpException() {}
	public EmpException(String msg) {
		super(msg);
	}
}
