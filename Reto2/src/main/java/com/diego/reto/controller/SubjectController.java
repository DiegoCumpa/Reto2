package com.diego.reto.controller;

import com.diego.reto.model.Subject;
import com.diego.reto.repository.SubjectRepository;
import com.diego.reto.service.SubjectService;
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
public class SubjectController {

    @Autowired(required = true)
    SubjectService subjectService;

    @Autowired(required = true)
    SubjectRepository subjectRepository;

    @GetMapping("/subjects")
    @ResponseBody
    public ResponseEntity<List<Subject>> getAllSubjects() {
        return new ResponseEntity<List<Subject>>(subjectService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/subjects")
    @ResponseBody
    public ResponseEntity<Subject> add(@RequestBody Subject subject) {
        Optional<Subject> OT = subjectRepository.findById(subject.getSubjectId());
        if (OT.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<Subject>(subjectService.save(subject), HttpStatus.CREATED);
    }

    @PutMapping("/subjects/{subjectId}")
    @ResponseBody
    public ResponseEntity<Subject> update(@RequestBody Subject subject, @PathVariable int subjectId) {
        Optional<Subject> OT = subjectRepository.findById(subjectId);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<Subject>(subjectService.update(subject, subjectId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/subjects/{subjectId}")
    @ResponseBody
    public ResponseEntity<Subject> delete(@PathVariable Integer subjectId) {
        Optional<Subject> OT = subjectRepository.findById(subjectId);
        if (!OT.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        subjectService.delete(subjectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
