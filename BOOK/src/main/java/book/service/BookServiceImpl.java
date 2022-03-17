package book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import book.Command.SearchCommand;
import book.DAO.BookDAO;
import book.VO.BookVO;

@Service
public class BookServiceImpl implements BookService{

	private BookDAO bookDAO;
	
	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public List<BookVO> list() {
		return bookDAO.list();
	}

	@Override
	public BookVO detail(int num) {
		return bookDAO.detail(num);
	}

	@Override
	public List<BookVO> search(SearchCommand searchcommand) {
		return bookDAO.search(searchcommand);
	}

	@Override
	public int insert(BookVO bookVO) {
		return bookDAO.insert(bookVO);
	}

	@Override
	public int delete(BookVO bookVO) {
		return bookDAO.delete(bookVO);
	}
	
	@Override
	public int isbnCheck (BookVO bookVO) {
		int result = 0;
		result = bookDAO.isbnCheck(bookVO);
		return result;
	}

}
