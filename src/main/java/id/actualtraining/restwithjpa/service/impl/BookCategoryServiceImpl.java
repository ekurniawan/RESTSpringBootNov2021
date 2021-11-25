package id.actualtraining.restwithjpa.service.impl;

import id.actualtraining.restwithjpa.entity.BookCategory;
import id.actualtraining.restwithjpa.exception.ResourceNotFoundException;
import id.actualtraining.restwithjpa.repository.BookCategoryRepository;
import id.actualtraining.restwithjpa.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    public List<BookCategory> GetAll() {
        return bookCategoryRepository.findAll();
    }

    @Override
    public BookCategory GetById(Long id) {
        return bookCategoryRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Book Category","Id",id));
    }

    @Override
    public BookCategory create(BookCategory bookCategory) {
        return bookCategoryRepository.save(bookCategory);
    }

    @Override
    public BookCategory update(Long id, BookCategory bookCategory) {
        BookCategory bookCatUpdate = GetById(id);
        bookCatUpdate.setName(bookCategory.getName());
        return bookCategoryRepository.save(bookCatUpdate);
    }

    @Override
    public void delete(Long id) {
        BookCategory book = GetById(id);
        bookCategoryRepository.delete(book);
    }
}
