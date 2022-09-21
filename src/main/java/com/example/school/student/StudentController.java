package com.example.school.student;
import com.example.school.subject.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    StudentService service;
    @Autowired
    StudentRepository repository;
    @Autowired
    SubjectRepository subjectRepository;
    @GetMapping
    public List<Students>findAllStudents(){
        return service.getAll();
    }
    @GetMapping("/{student_id}")
    Students student(
            @PathVariable Long student_id
    ){
        Students students=repository.findById(student_id).get();
        return students;
    }
    @PostMapping
    public ResponseEntity<Students>inputStudent(@RequestBody Students s){
        service.insertStudent(s);
        return new ResponseEntity<Students>(s, HttpStatus.ACCEPTED);
    }

}
