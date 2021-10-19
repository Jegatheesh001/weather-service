package com.projects.weatherservice.advice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.projects.weatherservice.business.vo.ErrorMessage;
import com.projects.weatherservice.exception.CustomException;

import lombok.extern.slf4j.Slf4j;

/**
 * Exception Handler
 * 
 * @author jegatheesh.mageswaran <br>
 *         <b>Created</b> On 19-Oct-2021
 *
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * Method to handle Custom Exception
	 * 
	 * @param ex
	 * @param request
	 * @return ApiResponseVO
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
	protected ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest request) {
		log.error(ex.getMessage());
		return handleExceptionInternal(ex, ex.getErrorMsg(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleOtherException(Exception ex, WebRequest request) {
		log.error(ex.getMessage(), ex);
		return handleExceptionInternal(ex, new ErrorMessage(500, "Unknown error occured. Contact technical team."),
				new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
}
