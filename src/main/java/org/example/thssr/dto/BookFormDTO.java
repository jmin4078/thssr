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
                .isAvailable(Boolean.TRUE.equals(isAvailable))
                .category(category)
                .build();
    }
    public static BookFormDTO fromEntity(BookEntity entity) {
        return BookFormDTO.builder()
                .title(entity.getTitle())
                .author(entity.getAuthor())
                .price(entity.getPrice())
                .discountPrice(entity.getDiscountPrice())
                .isAvailable(entity.isAvailable())
                .category(entity.getCategory())
                .build();
    }
}
