package com.nanos.test.model;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

}
