package com.deepak.api.exception;

import java.net.http.HttpHeaders;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.deepak.api.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
		
		 Map<String, String> errorDetails = new HashMap<>();
		 List<ObjectError> validationErrorList
		 
		 
	}
	
	

	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(
			CustomerAlreadyExistsException customerAlreadyExistsException, WebRequest webRequest) {

		//ErrorResponseDto errorResponseDto = new ErrorResponseDto(webRequest.getDescription(false),
				//HttpStatus.BAD_REQUEST, customerAlreadyExistsException.getMessage(), LocalDateTime.now());

		//return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponseDto(webRequest.getDescription(false),HttpStatus.BAD_REQUEST, customerAlreadyExistsException.getMessage(), 
						LocalDateTime.now()));
	}
	
	
	public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(
			ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponseDto(webRequest.getDescription(false),
						HttpStatus.NOT_FOUND,resourceNotFoundException.getMessage(),LocalDateTime.now()));
	}

}
