package id.actualtraining.restwithjpa.service.impl;

import id.actualtraining.restwithjpa.entity.Book;
import id.actualtraining.restwithjpa.exception.ResourceNotFoundException;
import id.actualtraining.restwithjpa.repository.BookRepository;
import id.actualtraining.restwithjpa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl  implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        /*Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent())
            return book.get();
        else
            return new Book();*/
        return bookRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Books","Id",id));
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        Book updateBook = getById(id);
        updateBook.setTitle(book.getTitle());
        updateBook.setWriter(book.getWriter());
        updateBook.setIsbn(book.getIsbn());
        return bookRepository.save(updateBook);
    }

    @Override
    public void delete(Long id) {
        Book deleteBook = getById(id);
        bookRepository.delete(deleteBook);
    }

    @Override
    public List<Book> findAllSortByTitle() {
        return bookRepository.findAllSortByTitle();
    }

    @Override
    public List<Book> findAllByWriter(String writer) {
        return bookRepository.findAllByWriter(writer);
    }
}
