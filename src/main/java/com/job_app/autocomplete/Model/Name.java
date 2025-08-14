package com.job_app.autocomplete.Model;



import jakarta.persistence.*;


@Entity
@Table(name = "Names")

public class Name {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Name() {
    }
    public Name(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



}
