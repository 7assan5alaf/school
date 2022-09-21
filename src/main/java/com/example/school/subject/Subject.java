package com.example.school.subject;

import com.example.school.student.Students;
import com.example.school.teacher.Teacher;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "subject_id")
    private Long id;
    @Column(name = "subject_name")
    private String name;
    @ManyToMany()
    @JoinTable(name = "enrolled_student",
            joinColumns =@JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Students>enrollStudent=new HashSet<>();

     @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
    public Subject(String name) {
        this.name = name;
    }

    public Subject(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subject() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Set<Students> getEnrollStudent() {
        return enrollStudent;
    }
    public  void  setEnrollStudent(Students student){
        enrollStudent.add(student);
    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void assingTeacherToStudent(Teacher teacher) {
        this.teacher=teacher;
    }
}
