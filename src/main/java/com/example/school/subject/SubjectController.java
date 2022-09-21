package com.example.school.subject;

import com.example.school.student.StudentRepository;
import com.example.school.student.Students;
import com.example.school.teacher.Teacher;
import com.example.school.teacher.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/subject")
public class SubjectController {
    @Autowired
    SubjectService service;
    @Autowired
    StudentRepository repository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @GetMapping
    public List<Subject> findAllStudents(){

        return service.getAll();
    }
    @GetMapping(path = "{subject_id}")
    Subject sub(
            @PathVariable("subject_id") Long subject_id
    ){
        Subject subject=subjectRepository.findById(subject_id).get();
        return subject;
    }
    @PostMapping
    public ResponseEntity<Subject> inputStudent(@RequestBody Subject su){
        service.insertSubject(su);
        return new ResponseEntity<Subject>(su, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{subject_id}/student/{student_id}")
    Subject enroll(
            @PathVariable Long subject_id,
            @PathVariable Long student_id
    ){
        Subject subject=subjectRepository.findById(subject_id).get();
        Students students=repository.findById(student_id).get();
       subject.setEnrollStudent(students);
       return subjectRepository.save(subject);
    }
    @PostMapping("/{subject_id}/teacher/{teacher_id}")
    Subject assignTeacher(
            @PathVariable Long subject_id,
            @PathVariable Long teacher_id
    ){
        Subject subject=subjectRepository.findById(subject_id).get();
        Teacher teacher=teacherRepository.findById(teacher_id).get();
        subject.assingTeacherToStudent(teacher);
        return subjectRepository.save(subject);
    }

}
