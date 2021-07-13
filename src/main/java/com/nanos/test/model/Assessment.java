package com.nanos.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "assessment")
@Table(name = "assessment")
@Data
public class Assessment {
    @Id
    @GeneratedValue
    @Column(name = "assessment_id")
    private Long id;
    @Column(name = "assessment_name")
    private String assessmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "owner_id",referencedColumnName = "user_id")
    private User owner = new User();

    @OneToMany(mappedBy = "assessment")
    @JsonManagedReference
    private List<Question> questions = new ArrayList<>();

}
