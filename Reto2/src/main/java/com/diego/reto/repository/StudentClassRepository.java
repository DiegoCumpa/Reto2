package com.diego.reto.repository;

import com.diego.reto.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jcumpale on 28/05/2019.
 */
@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass,Integer> {
}
