package com.zee.zee5app.advice;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zee.zee5app.exceptions.EntryAlreadyExistException;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

@ControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(EntryAlreadyExistException.class) // to handle the global level exception
	public ResponseEntity<?> entryAlreadyExistExceptionHandler(EntryAlreadyExistException e){
		HashMap<String, String> resData = new HashMap<>();
		resData.put("status", "Record already exist "+e.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(resData);
	}
	
	
	
	@ExceptionHandler(UnableToGenerateIdException.class) // to handle the global level exception
	public ResponseEntity<?> unableToGenerateIdExceptionHandler(UnableToGenerateIdException e){
		HashMap<String, String> resData = new HashMap<>();
		resData.put("status", "internal id creation proble");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resData);
	}
	
	
}
