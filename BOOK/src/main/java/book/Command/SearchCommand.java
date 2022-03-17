package book.Command;

public class SearchCommand {
	private String searchWord;
	private String searchOption;
	
	
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	@Override
	public String toString() {
		return "SearchCommand [searchWord=" + searchWord + ", searchOption=" + searchOption + "]";
	}
	
	

}
