package com.nanos.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Data
public class Answer {
    @Id
    @GeneratedValue
    @Column(name = "answer_id")
    private Long id;
    @Column(name = "answer_type")
    private String answerType;
    @Column(name = "answer")
    private String answer;
    @Column(name = "correct")
    private Boolean correct;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id",referencedColumnName = "question_id")
    @JsonBackReference
    private Question question = new Question();

}
