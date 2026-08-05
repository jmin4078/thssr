package org.example.thssr.model.repository;

import org.example.thssr.model.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findAllByTitleContaining(String keyword);
}