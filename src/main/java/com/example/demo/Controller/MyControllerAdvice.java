package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exceptions.EmptyInputException;
import com.example.demo.Exceptions.UserNotFoundException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException user){
		return new ResponseEntity<String>("The desired id is not present into the system",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException e){
		return new ResponseEntity<String>("One of the field is blank, Please have a look",HttpStatus.BAD_REQUEST);
	}
}
