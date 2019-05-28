package com.diego.reto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by jcumpale on 27/05/2019.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subjectId;

    @Column(name = "subject_name")
    private String subjectName;

    @JsonIgnore
    @OneToMany(mappedBy = "subject")
    private List<Class> listClasses;

    @Column(name = "isactive")
    private Integer status;

}
