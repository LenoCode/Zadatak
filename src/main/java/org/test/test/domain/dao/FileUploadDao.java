package org.test.test.domain.dao;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "file_upload")
@Getter
@Setter
@NoArgsConstructor
public class FileUploadDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="name")
    private String name;


    @Column(name="lastname")
    private String lastname;

    @Column(name = "created_time")
    private Timestamp timestamp;

    @Column(name="filename")
    private String filename;


    @Column(name="bytes")
    private byte[] bytes;


}
