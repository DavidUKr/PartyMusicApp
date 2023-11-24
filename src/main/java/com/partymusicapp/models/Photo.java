package com.partymusicapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Photo")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User userId;

    @Column
    private String filename;

    @Column
    private String fileType;

    @Column
    @Lob
    private byte[] data;
}
