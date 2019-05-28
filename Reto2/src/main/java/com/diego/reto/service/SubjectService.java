package com.diego.reto.service;

import com.diego.reto.model.Subject;

import java.util.List;

/**
 * Created by jcumpale on 28/05/2019.
 */
public interface SubjectService {

    public List<Subject> getAll();

    public Subject save(Subject subject);

    public Subject update(Subject subject, int subjectId);

    public Subject delete(Integer subjectId);
    
}
