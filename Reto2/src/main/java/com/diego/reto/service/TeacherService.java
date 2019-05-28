package com.diego.reto.service;

import com.diego.reto.model.Teacher;

import java.util.List;
import java.util.Optional;

/**
 * Created by jcumpale on 28/05/2019.
 */

public interface TeacherService {

    public List<Teacher> getAll();

    public Teacher save(Teacher teacher);

    public Teacher update(Teacher teacher, int teacherId);

    public Teacher delete(Integer teacherId);

}
