package com.example.school.teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/teachers")
public class TeacherController {

    @Autowired
    TeacherService service;
    @GetMapping
    public List<Teacher> findAllStudents(){
        return service.getAll();
    }
    @PostMapping
    public ResponseEntity<Teacher> inputStudent(@RequestBody Teacher t){
        service.insertTeacher(t);
        return new ResponseEntity<Teacher>(t, HttpStatus.ACCEPTED);
    }
}
