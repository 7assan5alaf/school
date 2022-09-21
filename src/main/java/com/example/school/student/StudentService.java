package com.example.school.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;
    public List<Students>getAll(){
        return repository.findAll();
    }


    public void insertStudent(Students s) {
        repository.save(s);
    }
}
