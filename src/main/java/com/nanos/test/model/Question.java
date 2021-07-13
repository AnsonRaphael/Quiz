package com.nanos.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
@Data
public class Question {
    @Id
    @GeneratedValue
    @Column(name = "question_id")
    private Long id;
    @Column(name = "q_text")
    private String qText;
    @Column(name = "q_image")
    private String qImage;
    @Column(name = "q_audio")
    private String qAudio;
    @Column(name = "q_video")
    private String qVideo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_id",referencedColumnName = "assessment_id")
    @JsonBackReference
    private Assessment assessment = new Assessment();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "question")
    @JsonManagedReference
    private Set<Answer> answers = new HashSet<>();

}
