package com.example.bookmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    public String bookName;
    public String authorName;
    public String bookDescription;
    public String bookImage;
    public Integer price;
    public Integer quantity;
}
