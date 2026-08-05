package org.example.thssr.model.repository;

import lombok.RequiredArgsConstructor;
import org.example.thssr.model.entity.BookEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl extends BookRepository {
    private final BookJpaRepository bookJpaRepository;

    @Override
    public void createBook(BookEntity entity) {
        bookJpaRepository.save(entity);
    }

    @Override
    public List<BookEntity> findAll() {
        return bookJpaRepository.findAll();
    }
    @Override
    public BookEntity findById(long id) {
        return bookJpaRepository.findById(id).orElseThrow();
    }

    @Override
    public void update(BookEntity entity) {
        bookJpaRepository.save(entity);
    }

    @Override
    public void deleteById(long id) {
        bookJpaRepository.deleteById(id);
    }
}
