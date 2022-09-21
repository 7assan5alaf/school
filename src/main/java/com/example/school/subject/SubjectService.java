package com.example.school.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectService {
    @Autowired
   SubjectRepository repository;
    public List<Subject> getAll(){
        return repository.findAll();
    }


    public void insertSubject(Subject su) {
        repository.save(su);
    }

}
