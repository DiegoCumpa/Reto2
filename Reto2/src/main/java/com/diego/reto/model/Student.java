package com.diego.reto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by jcumpale on 27/05/2019.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    @Getter @Setter
    private Integer studentId;

    @Column(name = "gender")
    @Getter @Setter
    private String gender;

    @Column(name = "first_name")
    @Getter @Setter
    private String firstName;

    @Column(name = "middle_name")
    @Getter @Setter
    private String middleName;

    @Column(name = "last_name")
    @Getter @Setter
    private String lastName;

    @Column(name = "date_of_birth")
    @Getter @Setter
    private Date dateOfBirth;

    @Column(name = "other_student_details")
    @Getter @Setter
    private String otherStudentDetails;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_classes", joinColumns =
    @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "class_id"))
    private List<Class> classes;

}
