package com.eagle.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.eagle.error.ErrorDetails;

@ControllerAdvice
public class GlobleExceptions {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> ValidationEceptionHandler(MethodArgumentNotValidException mx, WebRequest req) {
		
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(),"Validation Error",mx.getMessage());
		 
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> OtherExceptionHandler(Exception e, WebRequest req){
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), e.getMessage(),req.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}

}
