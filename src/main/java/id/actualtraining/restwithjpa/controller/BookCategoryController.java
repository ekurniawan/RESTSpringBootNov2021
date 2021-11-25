package id.actualtraining.restwithjpa.controller;

import id.actualtraining.restwithjpa.entity.BookCategory;
import id.actualtraining.restwithjpa.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookcategories")
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @GetMapping
    public List<BookCategory> getAll(){
        return bookCategoryService.GetAll();
    }

    @PostMapping
    public ResponseEntity<BookCategory> create(@RequestBody BookCategory bookCategory){
        return new ResponseEntity<BookCategory>(bookCategoryService.create(bookCategory),
                HttpStatus.OK);
    }

}
