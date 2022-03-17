package book.DAO;

import java.util.List;

import book.Command.SearchCommand;
import book.VO.BookVO;

public interface BookDAO {
	public abstract List<BookVO> list();
	public abstract BookVO detail(int num);
	public abstract List<BookVO> search(SearchCommand searchCommand);
	public abstract int insert (BookVO bookVO);
	public abstract int delete (BookVO bookVO);
	public abstract int isbnCheck (BookVO bookVO);
	
}
