package com.softtron.pinmaonews.exceptions;

public class CommonException extends RuntimeException {
	protected String code;
	protected String detail;

	public CommonException(String detail, String code) {
		this.detail = detail;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
