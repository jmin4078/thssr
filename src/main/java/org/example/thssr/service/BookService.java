package org.example.thssr.service;


import lombok.RequiredArgsConstructor;
import org.example.thssr.model.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
// import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;
}