package ru.innopolis;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    private Integer id;

    private String description;

    private Long price;

    private Long count;

}
