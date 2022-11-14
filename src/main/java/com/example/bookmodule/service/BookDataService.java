package com.example.bookmodule.service;

import com.example.bookmodule.dto.BookDto;
import com.example.bookmodule.model.BookData;
import com.example.bookmodule.repository.BookDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookDataService implements IBookService{
    @Autowired
    BookDataRepository bookDataRepository;

    public BookData createDetails(BookDto bookDto) {
        BookData bookData = new BookData(bookDto);
        return bookDataRepository.save(bookData);
    }

    public BookData updateDetails(Long bookId, BookDto bookDto) {
        BookData book = bookDataRepository.findById(bookId).orElse(null);
        if (book != null) {
            book.setBookName(bookDto.bookName);
            book.setAuthorName(bookDto.authorName);
            book.setBookDescription(bookDto.bookDescription);
            book.setBookImage(bookDto.bookImage);
            book.setPrice(bookDto.price);
            book.setQuantity(bookDto.quantity);
            return bookDataRepository.save(book);
        } else {
            return null;
        }
    }
    public BookData updateQuantity(Long bookId,int quantity){
        BookData bookData=bookDataRepository.findById(bookId).orElse(null);
        if (bookData!=null){
            bookData.setQuantity(quantity);
            return bookDataRepository.save(bookData);
        }else
            return null;
    }
    public List<BookData> retrieve(){
        return bookDataRepository.findAll();
    }
    public BookData deleteData(Long bookId){
        bookDataRepository.deleteById(bookId);
        return null;
    }
    public BookData findById(Long bookId){
       return bookDataRepository.findById(bookId).orElse(null);
    }
}