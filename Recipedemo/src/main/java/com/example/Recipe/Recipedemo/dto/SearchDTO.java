package com.example.Recipe.Recipedemo.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {
    String recipetype;
    Integer serve;
    String ingredients;
    String instructions;
    String flagingred;
    String flaginstruction;


}
