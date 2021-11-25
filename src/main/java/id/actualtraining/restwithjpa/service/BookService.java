package id.actualtraining.restwithjpa.service;

import id.actualtraining.restwithjpa.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book getById(Long id);
    Book create(Book book);
    Book update(Long id,Book book);
    void delete(Long id);
    List<Book> findAllSortByTitle();
    List<Book> findAllByWriter(String writer);
}
