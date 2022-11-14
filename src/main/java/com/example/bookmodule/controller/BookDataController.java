package com.example.bookmodule.controller;

import com.example.bookmodule.dto.BookDto;
import com.example.bookmodule.dto.ResponseDto;
import com.example.bookmodule.model.BookData;
import com.example.bookmodule.service.BookDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BookData")
public class BookDataController {
    @Autowired
    BookDataService bookDataService;
    @PostMapping("/addBook")
    public ResponseEntity<ResponseDto> addBook(@RequestBody BookDto bookDto){
        BookData bookData=bookDataService.createDetails(bookDto);
        ResponseDto responseDto=new ResponseDto("book data saved successful",bookData);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    @PutMapping("/updateBook/{bookId}")
    public ResponseEntity<ResponseDto> updateBook(@PathVariable long bookId,@RequestBody BookDto bookDto){
        BookData bookData=bookDataService.updateDetails(bookId,bookDto);
        ResponseDto responseDto=new ResponseDto("updated book data",bookData);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @PutMapping("/quantity/{bookId}/{quantity}")
    public BookData editQuantity(@PathVariable long bookId,@PathVariable int quantity){
        return bookDataService.updateQuantity(bookId,quantity);
    }
    @GetMapping("/getBooks")
    public List<BookData> retrieveBook(){
        return bookDataService.retrieve();
    }
    @DeleteMapping("/deleteBook/{bookId}")
    public ResponseEntity<ResponseDto> deleteBook(@PathVariable long bookId){
        BookData bookData=bookDataService.deleteData(bookId);
        ResponseDto responseDto=new ResponseDto("deleted bookId: "+bookId,bookData);
        return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
    @GetMapping("/getById/{bookId}")
    public BookData getById(@PathVariable long bookId){
        BookData bookData=bookDataService.findById(bookId);
        return bookData;
  //      ResponseDto responseDto=new ResponseDto("get book by id:"+bookId,bookData);
    //    return new ResponseEntity<>(responseDto,HttpStatus.OK);
    }
}
