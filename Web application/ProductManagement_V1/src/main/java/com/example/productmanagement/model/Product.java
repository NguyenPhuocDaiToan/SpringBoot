package com.example.productmanagement.model;

import com.example.productmanagement.validator.DateContraint;
import com.example.productmanagement.validator.PriceConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 20, message = "Độ dài tên phải từ 5 đến 20 kí tự")
    private String name;

    @PriceConstraint
    private double price;

    @DateContraint
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateCreate;

    @NotEmpty(message = "Mô tả không được để trống")
    private String description;

    @ManyToOne(targetEntity = Category.class)
    private Category category;
}
