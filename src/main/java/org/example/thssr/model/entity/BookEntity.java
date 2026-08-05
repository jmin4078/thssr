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

    public void update(String title, String author, int price, int discountPrice, boolean isAvailable, String category) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.discountPrice = discountPrice;
        this.isAvailable = isAvailable;
        this.category = category;
    }
}
