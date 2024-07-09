package com.example.ecom.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String category;
    private String description;
    private String name;
    private int price;
    private int stockQuantity;
    private Boolean productAvailable;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date releaseDate;
    private String imageName;
    private String imageType;
    @Lob
    @Column(name="image_data",columnDefinition = "LONGBLOB")
    private byte[] imageData;

}
