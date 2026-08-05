package org.example.thssr.model.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookRepositoryImpl extends BookRepository {
    private final BookJpaRepository bookJpaRepository;
}