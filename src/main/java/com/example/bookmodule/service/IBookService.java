package com.example.bookmodule.service;

import com.example.bookmodule.dto.BookDto;
import com.example.bookmodule.model.BookData;

import java.util.List;

public interface IBookService {
    public BookData createDetails(BookDto bookDto);
    public BookData updateDetails(Long bookId, BookDto bookDto);
    public List<BookData> retrieve();
    public BookData deleteData(Long bookId);
}
