package com.partymusicapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Table(name = "themes")
public class Theme {
    @Id
    private Long id;

    @NonNull
    @Column
    private String name;

    public Theme() {}
}
