package pl.spring.demo.to;

import java.util.List;


public class LibraryTo {

	private Long id;
    private String name;
	private List<BookTo> books;
	private Long version;
    
    public LibraryTo() {
	}

	public LibraryTo(Long id, String name, List<BookTo> books, Long version) {
		super();
		this.id=id;
		this.name = name;
		this.books = books;
		this.version=version;
	}
	
	public LibraryTo(Long id, String name, List<BookTo> books) {
		super();
		this.id=id;
		this.name = name;
		this.books = books;
	}
	
	public LibraryTo(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookTo> getBooks() {
		return books;
	}

	public void setBooks(List<BookTo> books) {
		this.books = books;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
