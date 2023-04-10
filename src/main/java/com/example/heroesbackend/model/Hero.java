package com.example.heroesbackend.model;

import com.example.heroesbackend.enumeration.Publisher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hero")
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String superhero;
    private Publisher publisher;
    private String alterEgo;
    private String firstAppearance;
    private String character;
    private String altImg;
}
