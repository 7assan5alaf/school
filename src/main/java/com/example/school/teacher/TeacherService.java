package com.example.school.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherService {
    @Autowired
    TeacherRepository repository;
    public List<Teacher> getAll(){
        return repository.findAll();
    }


    public void insertTeacher(Teacher t) {
        repository.save(t);
    }
}
