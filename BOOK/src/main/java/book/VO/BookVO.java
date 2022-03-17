package book.VO;
/*
    NUM number primary key,
    ISBN number unique,
    TITLE varchar2(255) not null ,
    AUTHOR varchar2(255) not null,
    PUBLISHER varchar2(255) not null,
    PRICE int not null,
    
    INTRO varchar2(255) not null*/

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("BookVO")
public class BookVO {
	
	private int num;
	private MultipartFile img;
	private String name;
	private String isbn;
	private String title;
	private String author;
	private String publisher;
	private String price;
	
	private String intro;
	
	public BookVO() {}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public MultipartFile getImg() {
		return img;
	}

	public void setImg(MultipartFile img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public BookVO(int num, MultipartFile img, String name, String isbn, String title, String author, String publisher,
			String price, String intro) {
		super();
		this.num = num;
		this.img = img;
		this.name = name;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.intro = intro;
	}
	
	
	
	
	

	
}
