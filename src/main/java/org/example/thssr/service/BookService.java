package org.example.thssr.service;


import lombok.RequiredArgsConstructor;
import org.example.thssr.model.entity.BookEntity;
import org.example.thssr.model.repository.BookRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        return Optional.ofNullable(bookRepository.findAll()).orElseGet(List::of);
    }

    public BookEntity findById(long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public void updateBook(long id, org.example.thssr.dto.BookFormDTO form) {
        BookEntity book = bookRepository.findById(id);
        book.update(form.getTitle(), form.getAuthor(), form.getPrice(), form.getDiscountPrice(), Boolean.TRUE.equals(form.getIsAvailable()), form.getCategory());
        bookRepository.update(book);
    }

    @Transactional
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

    public List<BookEntity> search(String keyword) {
        return bookRepository.search(keyword);
    }
}
