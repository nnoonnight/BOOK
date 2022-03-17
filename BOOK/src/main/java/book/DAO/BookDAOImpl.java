package book.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import book.Command.SearchCommand;
import book.VO.BookVO;

//JpaRepository 를 사용하며, 데이터베이스에 CRUD 의 명령을 쿼리 없이 전달하여 실행 가능
@Repository
public class BookDAOImpl implements BookDAO {

	private SqlSessionTemplate sqlSessionTemplate;
	
	public BookDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	private void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;

	}
	@Override
	public List<BookVO> list() {		
		return sqlSessionTemplate.selectList("list");
	}

	@Override
	public BookVO detail(int num) {
		return sqlSessionTemplate.selectOne("detail", num);
	}

	@Override
	public List<BookVO> search(SearchCommand searchCommand) {
		return sqlSessionTemplate.selectList("search", searchCommand);
	}

	@Override
	public int insert(BookVO bookVO) {
		 return sqlSessionTemplate.insert("insert", bookVO);
	}

	@Override
	public int delete(BookVO bookVO) {
		return sqlSessionTemplate.delete("delete",bookVO);

	}

	@Override
	public int isbnCheck (BookVO bookVO) {
		int result = 0;	
		return sqlSessionTemplate.selectOne("isbnCheck", bookVO.getIsbn() );
	}

}
