package com.diego.reto.service;

import com.diego.reto.model.Subject;
import com.diego.reto.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jcumpale on 28/05/2019.
 */
@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private SubjectRepository subjectRepository;


    @Override
    public List<Subject> getAll(){
        return (List<Subject>) subjectRepository.findAll();
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public Subject update(Subject subject, int subjectId) {
        subjectRepository.findById(subjectId).ifPresent((p) -> {
            subject.setSubjectId(subjectId);
            subjectRepository.save(subject);
        });
        return subject;
    }

    @Override
    public Subject delete(Integer subjectId) {
        subjectRepository.findById(subjectId).ifPresent((p) -> {
            subjectRepository.deleteSubject(subjectId);
        });
        return null;
    }
    
}
