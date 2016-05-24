package pl.spring.demo.repository;

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

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

	@Autowired
	private LibraryRepository libraryRepository;

	@Autowired
	private BookRepository bookRepository;

	 @Test
	 @Sql(scripts = "import.sql")
	 @DirtiesContext
	 public void testShouldFindLibraryByName() {
	 // given
	 String name = "libr";
	 // when
	 List<LibraryEntity> libraryEntities =
	 libraryRepository.findLibraryByName(name);
	 // then
	 assertFalse(libraryEntities.isEmpty());
	 assertEquals(6, libraryEntities.size());
	 }
	
	 @Test
	 @Sql(scripts = "import.sql")
	 @DirtiesContext
	 public void testShouldFindLibraryByName2() {
	 // given
	 String name = "library 3";
	 // when
	 List<LibraryEntity> libraryEntities = libraryRepository.findLibraryByName(name);
	 // then
	 assertFalse(libraryEntities.isEmpty());
	 assertEquals(1, libraryEntities.size());
	 }
	 
	 @Test
	 @Sql(scripts = "import.sql")
	 @DirtiesContext
	 public void testShouldFindLibraryByBook() {
	 // given
	 String bookTitle = "pierwsza";
	 // when
	 List<LibraryEntity> libraryEntities = libraryRepository.findLibraryByBook(bookTitle);
	 // then
	 assertFalse(libraryEntities.isEmpty());
	 assertEquals(1, libraryEntities.size());
	 }

	@Test
	@Sql(scripts = "import.sql")
	@DirtiesContext
	public void testShouldDeleteLibraryAndBooks() {
		// when
		LibraryEntity libraryEntity = libraryRepository.findLibraryByName("Library 2").get(0);
		int numberOfBooksBeforeDelete = bookRepository.findAll().size();
		int numberOfLibrariesBeforeDelete = libraryRepository.findAll().size();
		libraryRepository.delete(libraryEntity);
		int numberOfBooksAfterDelete = bookRepository.findAll().size();
		int numberOfLibrariesAfterDelete = libraryRepository.findAll().size();
		// then
		assertEquals(6, numberOfLibrariesBeforeDelete);
		assertEquals(5, numberOfLibrariesAfterDelete);
		assertEquals(6, numberOfBooksBeforeDelete);
		assertEquals(2, numberOfBooksAfterDelete);
	}

}
