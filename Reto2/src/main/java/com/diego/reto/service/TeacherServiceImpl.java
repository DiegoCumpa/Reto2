package com.diego.reto.service;

import com.diego.reto.model.Teacher;
import com.diego.reto.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by jcumpale on 28/05/2019.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public List<Teacher> getAll(){
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Teacher teacher, int teacherId) {
        teacherRepository.findById(teacherId).ifPresent((p) -> {
            teacher.setTeacherId(teacherId);
            teacherRepository.save(teacher);
        });
        return teacher;
    }

    @Override
    public Teacher delete(Integer teacherId) {
        teacherRepository.findById(teacherId).ifPresent((p) -> {
            teacherRepository.deleteTeacher(teacherId);
        });
        return null;
    }


}
