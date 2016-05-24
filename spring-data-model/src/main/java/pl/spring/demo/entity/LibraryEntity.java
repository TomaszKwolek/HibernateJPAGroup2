package pl.spring.demo.entity;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "LIBRARY")
public class LibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, length = 50)
    private String name;
    
    @OneToMany(mappedBy="library", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<BookEntity> books;
    
    @Version
    @Column(name = "optlock")
    private Long version;
    
    public LibraryEntity() {
	}

	public LibraryEntity(Long id, String name, List<BookEntity> books, Long version) {
		super();
		this.id=id;
		this.name = name;
		this.books = books;
		this.version = version;
	}
	
	public LibraryEntity(Long id, String name, List<BookEntity> books) {
		super();
		this.id=id;
		this.name = name;
		this.books = books;
	}

	public LibraryEntity(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
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
