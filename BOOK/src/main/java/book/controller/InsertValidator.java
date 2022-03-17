package book.controller;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import book.VO.BookVO;


public class InsertValidator implements Validator {

	
	
	@Override
	public void validate(Object target, Errors errors) {
		//target : 검사 대상 객체
		//errors : 검사 결과 에러코드를 저장하는 객체
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publisher", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "intro", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "required");
	}

	@Override
	public boolean supports(Class<?> arg0) {
		//스프링 mvc에서 전달받은 객체를 자동으로 검증할 경우 제대로 구현 필요
		return BookVO.class.isAssignableFrom(arg0);
	}
}