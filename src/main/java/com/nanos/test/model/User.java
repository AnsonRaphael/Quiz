package com.nanos.test.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "user")
@Table(name = "user")
@Data
public class User{

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    @Column(name = "name" ,unique = true)
    private String username;
    @Column(name = "email",unique = true)
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password")
    private String password;
    @Column(name = "enabled",columnDefinition = "boolean default false")
    private boolean enabled;
    @Column(name = "created_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",insertable = false,updatable = false)
    private Date createdDate;

    @OneToMany(mappedBy = "owner",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Assessment> assessments = new ArrayList<Assessment>();
}
