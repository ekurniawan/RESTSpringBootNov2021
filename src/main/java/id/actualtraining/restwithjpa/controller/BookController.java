package id.actualtraining.restwithjpa.controller;

import id.actualtraining.restwithjpa.entity.Book;
import id.actualtraining.restwithjpa.model.MyStatus;
import id.actualtraining.restwithjpa.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Mengambil semua data buku",
            description = "Mengambil semua data buku")
    @ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Semua buku ditemukan",
            content = {@Content(mediaType = "application/json",schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "404",description = "buku tidak ditemukan",content = @Content)})
    @GetMapping
    public List<Book> getAll(){
        return bookService.findAll();
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book){
        return new ResponseEntity<Book>(bookService.create(book),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id,
                                       @RequestBody Book book){
        return new ResponseEntity<Book>(bookService.update(id,book),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id){
        return bookService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MyStatus> deleteBook(@PathVariable Long id){
        MyStatus myStatus = MyStatus.builder().kode("DD01")
                .deskripsi("Data book id:" +
                id.toString() + " berhasil didelete").build();
        bookService.delete(id);
        return new ResponseEntity<MyStatus>(myStatus,HttpStatus.OK);
    }

    @GetMapping("/sortbytitle")
    public List<Book> getAllSortByTitle(){
        return bookService.findAllSortByTitle();
    }

    @GetMapping("/getbywriter")
    public List<Book> getAllByWriter(@RequestParam(name = "writer") String writer){
        return bookService.findAllByWriter(writer);
    }
}
