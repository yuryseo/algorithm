package com.ssafy.model.dto;

public class ItemException extends RuntimeException {
	public ItemException() {
		super("상품 정보 처리 중 오류 발생");
	}
	public ItemException(String msg) {
		super(msg);
	}
}
