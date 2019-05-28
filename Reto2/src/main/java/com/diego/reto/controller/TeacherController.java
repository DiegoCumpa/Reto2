package com.diego.reto.controller;

import com.diego.reto.model.Teacher;
import com.diego.reto.repository.TeacherRepository;
import com.diego.reto.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by jcumpale on 28/05/2019.
 */
@RestController
@RequestMapping(path ="/reto2/api/v1" )
public class TeacherController {

    @Autowired(required = true)
    TeacherService teacherService;

    @Autowired(required = true)
    TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    @ResponseBody
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return new ResponseEntity<List<Teacher>>(teacherService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/teachers")
    @ResponseBody
    public ResponseEntity<Teacher> add(@RequestBody Teacher teacher) {
        Optional<Teacher> OT = teacherRepository.findById(teacher.getTeacherId());
        if (OT.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Teacher>(teacherService.save(teacher), HttpStatus.CREATED);
    }

    @PutMapping("/teachers/{teacherId}")
    @ResponseBody
    public ResponseEntity<Teacher> update(@RequestBody Teacher teacher, @PathVariable int teacherId) {
        Optional<Teacher> OT = teacherRepository.findById(teacherId);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Teacher>(teacherService.update(teacher, teacherId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/teachers/{teacherId}")
    @ResponseBody
    public ResponseEntity<Teacher> delete(@PathVariable Integer teacherId) {
        Optional<Teacher> OT = teacherRepository.findById(teacherId);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        teacherService.delete(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
