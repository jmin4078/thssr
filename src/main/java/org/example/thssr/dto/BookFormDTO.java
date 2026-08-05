package org.example.thssr.dto;

import lombok.*;
import org.example.thssr.model.entity.BookEntity;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookFormDTO {
    private String title;
    private String author;
    private int price;
    private int discountPrice;
    private Boolean isAvailable;
    private String category;

    public BookEntity toEntity() {
        return BookEntity.builder()
                .title(title)
                .author(author)
                .price(price)
                .discountPrice(discountPrice)
                .isAvailable(isAvailable)
                .category(category)
                .build();
    }
}