package book.service;

import java.util.List;

import book.Command.SearchCommand;
import book.VO.BookVO;

public interface BookService {
	
	public abstract List<BookVO> list();
	public abstract BookVO detail(int num);
	public abstract List<BookVO> search(SearchCommand searchWord);
	public abstract int insert (BookVO bookVO);
	public abstract int delete (BookVO bookVO);
	public abstract int isbnCheck (BookVO bookVO);
	
}
