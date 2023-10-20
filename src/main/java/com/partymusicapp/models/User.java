package com.partymusicapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    private Long id;

    @NonNull
    @Column
    private String name;



    public User() {}
}
