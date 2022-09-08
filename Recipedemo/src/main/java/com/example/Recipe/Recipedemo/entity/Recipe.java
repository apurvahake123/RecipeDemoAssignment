package com.example.Recipe.Recipedemo.entity;

import lombok.*;

import javax.persistence.*;
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

/**
 * Recipe Entity
 */
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer recipeid;
    String recipename;
    String recipetype;
    Integer serve;
    String ingredients;
    String instructions;

    public Object getBody() {
        return null;
    }
}
