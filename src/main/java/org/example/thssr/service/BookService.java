package org.example.thssr.service;


import lombok.RequiredArgsConstructor;
import org.example.thssr.model.entity.BookEntity;
import org.example.thssr.model.repository.BookRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
// import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public void createBook(BookEntity entity) {
        bookRepository.createBook(entity);
    }

    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }
}