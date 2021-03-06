package pl.spring.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;

import java.util.List;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Long> {

    @Query("select library from LibraryEntity library where upper(library.name) like concat(upper(:name), '%')")
    public List<LibraryEntity> findLibraryByName(@Param("name") String name);

    @Query("select library from LibraryEntity library JOIN library.books book where upper(book.title) like concat('%', upper(:title), '%')")
    public List<LibraryEntity> findLibraryByBook(@Param("title") String title);
    
}
