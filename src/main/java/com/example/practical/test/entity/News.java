package com.example.practical.test.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Entity 
@Getter 
@Setter
public class News {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String headline;

    @Column (nullable = false)
    private String description;

    @Enumerated (EnumType.STRING)
    @Column (nullable = false)
    private NewsCategory newsCategory;

    private LocalDateTime createdAt = LocalDateTime.now();

     @OneToMany(
        mappedBy = "news",
        cascade = CascadeType.ALL
    )
    private List<Comment> comments;

}
