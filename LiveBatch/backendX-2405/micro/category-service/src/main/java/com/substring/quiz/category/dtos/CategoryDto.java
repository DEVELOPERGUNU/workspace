package com.substring.quiz.category.dtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private String Id;

    private String title;

    private String description;

    private boolean active;
}
