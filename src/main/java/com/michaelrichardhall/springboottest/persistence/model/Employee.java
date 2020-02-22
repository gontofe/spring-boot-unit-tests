package com.michaelrichardhall.springboottest.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
@Getter @Setter
public class Employee {

    public Employee(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min=3, max=20)
    private String name;

    public Employee(String name) {
        this.name = name;
    }
}
