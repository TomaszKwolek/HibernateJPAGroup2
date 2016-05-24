package pl.spring.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;
import pl.spring.demo.service.BookService;
import pl.spring.demo.service.impl.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookServiceImplTest {

	@Autowired
	private BookService bookService;
	
	 @Test
	 @Sql(scripts = "import.sql")
	 @DirtiesContext
	 public void testShouldFindAllBooksByCriteria() {
	 //given
	 BookSearchCriteria bsc = new BookSearchCriteria(null, null, null);
	 //when
	 List<BookTo> books = bookService.findBooksByCriteria(bsc);
	 //then
	 assertFalse(books.isEmpty());
	 assertEquals(6, books.size());
	 }
	 
	 @Test
	 @Sql(scripts = "import.sql")
	 @DirtiesContext
	 public void testShouldFindAllBooksByCriteria2() {
	 //given
	 BookSearchCriteria bsc = new BookSearchCriteria("kS", null, "lIbRa");
	 //when
	 List<BookTo> books = bookService.findBooksByCriteria(bsc);
	 //then
	 assertFalse(books.isEmpty());
	 assertEquals(6, books.size());
	 }
	 
	 @Test
	 @Sql(scripts = "import.sql")
	 @DirtiesContext
	 public void testShouldFindAllBooksByCriteria3() {
	 //given
	 BookSearchCriteria bsc = new BookSearchCriteria("kS", "a", "lIbRa");
	 //when
	 List<BookTo> books = bookService.findBooksByCriteria(bsc);
	 //then
	 assertFalse(books.isEmpty());
	 assertEquals(6, books.size());
	 }
	 
	 @Test
	 @Sql(scripts = "import.sql")
	 @DirtiesContext
	 public void testShouldFindAllBooksByCriteria4() {
	 //given
	 BookSearchCriteria bsc = new BookSearchCriteria("", "", "");
	 //when
	 List<BookTo> books = bookService.findBooksByCriteria(bsc);
	 //then
	 assertFalse(books.isEmpty());
	 assertEquals(6, books.size());
	 }
	 
	 @Test
	 @Sql(scripts = "import.sql")
	 @DirtiesContext
	 public void testShouldFindFourBooksByCriteriaLibraryName() {
	 //given
	 BookSearchCriteria bsc = new BookSearchCriteria(null, null, "lIbRary 2");
	 //when
	 List<BookTo> books = bookService.findBooksByCriteria(bsc);
	 //then
	 assertFalse(books.isEmpty());
	 assertEquals(4, books.size());
	 }
	 
	 @Test
	 @Sql(scripts = "import.sql")
	 @DirtiesContext
	 public void testShouldFindOneBooksByCriteriaTitle() {
	 //given
	 BookSearchCriteria bsc = new BookSearchCriteria("trZecia", null, null);
	 //when
	 List<BookTo> books = bookService.findBooksByCriteria(bsc);
	 //then
	 assertFalse(books.isEmpty());
	 assertEquals(1, books.size());
	 assertEquals("Trzecia książka", books.get(0).getTitle());
	 }
	 
	 @Test
	 @Sql(scripts = "import.sql")
	 @DirtiesContext
	 public void testShouldFindOneBooksByCriteriaAuthor() {
	 //given
	 BookSearchCriteria bsc = new BookSearchCriteria(null, "Nowakowski", null);
	 //when
	 List<BookTo> books = bookService.findBooksByCriteria(bsc);
	 //then
	 assertFalse(books.isEmpty());
	 assertEquals(1, books.size());
	 assertEquals("Piąta książka", books.get(0).getTitle());
	 }
	  
}
