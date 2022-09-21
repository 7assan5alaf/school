package com.example.school.student;

import com.example.school.subject.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrollStudent")
    private Set<Subject>enrollSubject=new HashSet<>();

    public Students(String name) {
        this.name = name;
    }

    public Students(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Students() {

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

    public Set<Subject> getEnrollSubject() {
        return enrollSubject;
    }
    public void subjects(Subject s){
        enrollSubject.add(s);
    }
}
