package book.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//어디에 쓰이는지 모르겠음

@ControllerAdvice("BOOK")
public class CommonExceptionHandler {
	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "error";
	}

}
