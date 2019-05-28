package com.diego.reto.repository;

import com.diego.reto.model.Subject;
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
public interface SubjectRepository extends JpaRepository<Subject,Integer> {


    @Query(value = "SELECT * from subjects where isactive = 1 order by subject_id ASC",nativeQuery = true)
    public List<Subject> findAll();

    @Modifying
    @Transactional
    @Query(value = "update subjects set isactive=0 where subject_id = ?1", nativeQuery = true)
    void deleteSubject(Integer idSuject);



}
