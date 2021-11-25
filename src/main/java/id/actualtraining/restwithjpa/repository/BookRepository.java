package id.actualtraining.restwithjpa.repository;

import id.actualtraining.restwithjpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query(nativeQuery = true,value = "select * from book order by title asc")
    List<Book> findAllSortByTitle();

    @Query(nativeQuery = true,value = "select * from book where writer like CONCAT('%', ?1, '%')")
    List<Book> findAllByWriter(String writer);
}
