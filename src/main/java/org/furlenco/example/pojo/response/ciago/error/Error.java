package org.furlenco.example.pojo.response.ciago.error;

import lombok.Data;

@Data
public class Error{
	private String code;
	private Object data;
	private String name;
	private String message;
	private String resolutionMessage;
}