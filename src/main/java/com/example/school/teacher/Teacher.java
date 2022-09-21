package com.example.school.teacher;

import com.example.school.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id")
    private Long id;
    @Column(name = "teacher_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    Set<Subject>subjects=new HashSet<>();
    public Teacher(String name) {
        this.name = name;
    }

    public Teacher(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Teacher() {

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
    public Set<Subject> getSubjects() {
        return subjects;
    }

}
