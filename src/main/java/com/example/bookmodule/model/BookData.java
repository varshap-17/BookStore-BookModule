package com.example.bookmodule.model;

import com.example.bookmodule.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;
    private String bookName;
    private String authorName;
    private String bookDescription;
    private String bookImage;
    private Integer price;
    private Integer quantity;

    public BookData(BookDto bookDto){
        this.bookName=bookDto.bookName;
        this.authorName=bookDto.authorName;
        this.bookDescription=bookDto.bookDescription;
        this.price=bookDto.price;
        this.bookImage=bookDto.bookImage;
        this.quantity=bookDto.quantity;
    }
}
