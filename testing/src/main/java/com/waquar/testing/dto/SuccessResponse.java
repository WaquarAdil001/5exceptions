package com.waquar.testing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Kevin Mkenya <kevinmkenya2@gmail.com>
 */
@Data
@AllArgsConstructor
public class SuccessResponse {

	 
	private Boolean success;
	private int statusCode;
	// General error message about nature of error
	private String message;

	private Object data;
}
