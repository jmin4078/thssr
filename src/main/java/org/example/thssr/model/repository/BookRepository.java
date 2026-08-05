package org.example.thssr.model.repository;


import org.example.thssr.model.entity.BookEntity;

import java.util.List;

public abstract class BookRepository {
    public abstract void createBook(BookEntity entity);
    public abstract List<BookEntity> findAll();
}