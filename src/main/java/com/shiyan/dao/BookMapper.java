package com.shiyan.dao;

import com.github.pagehelper.Page;
import com.shiyan.domain.Book;

public interface BookMapper {
//根据id查询图书信息
    Book findById(String id);
    Page<Book> selectNewBooks();
    Page<Book> searchBooks(Book book);
    Integer addBook(Book book);
    Integer editBook(Book book);
    Page<Book> selectBorrowed(Book book);
    Page<Book> selectMyBorrowed(Book book);

}
