package org.example.thssr.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookEntity extends BaseEntity {
    private String title;
    private String author;
    private int price;
    private int discountPrice;
    private boolean isAvailable;
    private String category;
}