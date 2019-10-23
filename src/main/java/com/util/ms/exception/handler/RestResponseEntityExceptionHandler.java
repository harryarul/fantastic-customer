package com.util.ms.exception.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import net.sf.json.JSONObject;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	/**
	 * Handle the JSR303 validation
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		StringBuilder sb = new StringBuilder();
		for (FieldError fieldError: ex.getBindingResult().getFieldErrors()) {
			sb.append(fieldError.getDefaultMessage()).append(", ");
        }
		final String msg = sb.toString();
		JSONObject jsonResponse = buildResponse(null, StringUtils.substring(msg, 0, msg.lastIndexOf(", ")));
		return handleExceptionInternal(ex, jsonResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	/**
	 * Handle the unknown parameters and type mismatch
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.debug("handleHttpMessageNotReadable", ex);
		final String exceptionMsg = ex.getMessage();
		String errorMsg = null;
		if (exceptionMsg != null && exceptionMsg.contains("Can not construct instance")) {
			errorMsg = extractTypeMismatch(exceptionMsg);
		} else {
			errorMsg = extractUnknownProperties(ex);
		}
		
		JSONObject jsonResponse = buildResponse(null, errorMsg);
		return handleExceptionInternal(ex, jsonResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
		
	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<Object> handleIllegalArgumentRequest(IllegalArgumentException ex, WebRequest request) {
		JSONObject jsonResponse = buildResponse(null, ex.getMessage());
		return handleExceptionInternal(ex, jsonResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	/**
	 * Try and extract the user friendly message from the stacktrace. We want to hide implementation details and 
	 * only provide a simple helpful message.
	 * Not the prettiest method, but it will have to do
	 * @param ex
	 * @return
	 */
	private String extractUnknownProperties(HttpMessageNotReadableException ex) {
		try {
			
			final String notMarkedIgnorable = "not marked as ignorable ";

			final String exMsg = ex.getMessage();
			final String errorMsg = StringUtils
					.trim(StringUtils.substring(exMsg, exMsg.indexOf(":") + 2, exMsg.indexOf("(")));
			
			final String knownParameters = StringUtils.trim(StringUtils.substring(exMsg,
					exMsg.indexOf(notMarkedIgnorable) + notMarkedIgnorable.length(), exMsg.indexOf("\n")));
			
			return replaceDoubleQuotes(errorMsg + knownParameters);
			
		} catch (Exception e) {
			logger.error("Failed to extract friendly message", e);
			return ex.getMessage();
		}
	}

	/**
	 * Try and extract the user friendly message for TypeMismatchException
	 * @param ex
	 * @return
	 */
	private String extractTypeMismatch(final String str) {
		try {
			return replaceDoubleQuotes(StringUtils.substring(str, str.indexOf(":") + 2, str.indexOf(";")));
			
		} catch (Exception e) {
			logger.error("couldn't extract friendly message", e);
			return str;
		}
	}
	
	private String replaceDoubleQuotes(final String str) {
		return StringUtils.replace(str, "\"", "'");
	}
	
	private JSONObject buildResponse(final Integer errorCode, final String message) {
		JSONObject jsonResponse = new JSONObject();
		
		if (errorCode != null)
			jsonResponse.put("errorCode", errorCode);
		
		jsonResponse.put("message", message);
		
		return jsonResponse;
	}

}
