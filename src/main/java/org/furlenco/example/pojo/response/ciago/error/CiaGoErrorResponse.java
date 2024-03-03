package org.furlenco.example.pojo.response.ciago.error;

import lombok.Data;

@Data
public class CiaGoErrorResponse{
	private boolean success;
	private Error error;
}