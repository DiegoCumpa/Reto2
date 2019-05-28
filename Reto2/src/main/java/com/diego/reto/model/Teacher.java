package com.diego.reto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;

    private String gender;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "other_teacher_details")
    private String otherDetails;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private List<Class> listClasses;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    @Column(name = "isactive")
    private Integer status;


}
