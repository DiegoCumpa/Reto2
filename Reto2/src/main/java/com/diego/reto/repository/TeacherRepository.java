package com.diego.reto.repository;

import com.diego.reto.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jcumpale on 28/05/2019.
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {


    @Query(value = "SELECT * from teachers where isactive = 1 order by teacher_id ASC",nativeQuery = true)
    public List<Teacher> findAll();

    @Modifying
    @Transactional
    @Query(value = "update teachers set isactive=0 where teacher_id = ?1", nativeQuery = true)
    void deleteTeacher(Integer idTeacher);


}
