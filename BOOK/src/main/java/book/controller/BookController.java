package book.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import book.Command.SearchCommand;
import book.VO.BookVO;
import book.service.BookServiceImpl;

@Controller
public class BookController {
	private BookServiceImpl bookService;
	
	public void setBookService(BookServiceImpl bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/books/list")
	public String list(Model model) {
		model.addAttribute("bookList", bookService.list());
		return "/book_list";
	}
	
	//ReqeustMappring 어노테이션의 value속성중 {seq}속성: 경로변수를 메서드 인자로 사용 가능 (@PathVariable로 지정)
	@RequestMapping(value="books/read/{seq}") 
	public String detail(Model model, @PathVariable int seq) {	//@PathVariable를 int로 변환하여 detail.()의 변수로 사용 가능
		
		BookVO detail = bookService.detail(seq);
		if(detail == null) {
			return "error";
		}
		model.addAttribute("bookDetail", detail);
		
		return "/book_detail";	
	}
	
	//form
	@RequestMapping(value="books/add", method=RequestMethod.GET)
	public String insert(@ModelAttribute("regForm")BookVO bookVO) {
		return "/book_reg_form";	
	}
	
	//insert
	@RequestMapping(value="books/add" , method=RequestMethod.POST) //errors 객체는 무조건 커맨드 객체 뒤에
	public String insert(@ModelAttribute("regForm")BookVO bookVO,Errors errors ,HttpServletRequest request) throws Exception, IOException {
		new InsertValidator().validate(bookVO, errors);
		if(errors.hasErrors()) {
			return "/book_reg_form";
		}
		MultipartFile file = bookVO.getImg();
		try {
			
			int result = bookService.isbnCheck(bookVO);
			
			if(result >= 1) {
				throw new AlreadyExistingIsbnException();
			}
			
			//파일명
			String originalFileName = file.getOriginalFilename();
			
			//파일명 중 확장자만 추출
			String originalFileExtension = FilenameUtils.getExtension(originalFileName); //확장자 구하기
			
			//저장할때 쓸 파일명 랜덤생성 + 확장자
			String storedFileName = UUID.randomUUID().toString().replaceAll("-", "")+"."+originalFileExtension;
			
			//파일 저장을 위한 File 객체
			String rootPath = request.getSession().getServletContext().getRealPath("/");  

		    String attachPath = "resources/upload/";
			file.transferTo(new File(rootPath + attachPath +storedFileName));
		
			
		bookVO.setName(storedFileName); //저장할 파일 (랜덤생성된)이름을 vo에 셋팅
		bookService.insert(bookVO);
		return "redirect:/books/list";
		} catch (AlreadyExistingIsbnException e) {
			errors.rejectValue("isbn", "duplicate");
			return "/book_reg_form";
		} catch (Exception e) {
			return "/book_reg_form";
		}
	}
	
	
	@RequestMapping(value="books/search")
	public String search(SearchCommand searchCommand, Model model) {
		model.addAttribute("bookList", bookService.search(searchCommand));
		model.addAttribute("searchCommand", searchCommand);
		return "/search";	
	}
	
	
	@ExceptionHandler(TypeMismatchException.class)
	public String handlerTypeMismatchException() {
		return "error";
	}

	

}
