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
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "school_id")
    private int idSchool;
    @Column(name = "name_school")
    private String nameSchool;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Teacher> listTeachers;


}
