package com.waquar.testing.dto;

import java.util.HashMap;

import com.fasterxml.jackson.databind.util.JSONPObject;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

	private Boolean success;
	private int statusCode;
	// General error message about nature of error
	private String message;

	// Specific errors in API request processing
	private HashMap<String, String> details;

	private JSONPObject data;
}
