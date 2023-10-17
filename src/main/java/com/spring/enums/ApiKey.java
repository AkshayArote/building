package com.spring.enums;

public enum ApiKey {
	MESSAGE("message"),SUCCES("succse"),DATA("data");
	String value;
	ApiKey(String value) {
		this.value=value;
	}
	public String val() {
		return value;
	}
}
