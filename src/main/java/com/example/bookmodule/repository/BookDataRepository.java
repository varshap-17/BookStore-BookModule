package com.example.bookmodule.repository;

import com.example.bookmodule.model.BookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDataRepository extends JpaRepository<BookData,Long> {
}
