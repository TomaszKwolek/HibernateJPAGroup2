package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.service.impl.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

public interface BookService {

    List<BookTo> findAllBooks();
    List<BookTo> findBooksByTitle(String title);
    List<BookTo> findBooksByAuthor(String author);
    List<BookTo> findBooksByCriteria(BookSearchCriteria bsc);

    BookTo saveBook(BookTo book);
}
