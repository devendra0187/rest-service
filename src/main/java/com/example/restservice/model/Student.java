package com.example.restservice.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="students")
@EntityListeners(AuditingEntityListener.class)

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  Long id;
    @Column(name = "first_name",nullable = false)
    private  String firstname;

    @Column(name = "last_name", nullable = false)
    private  String lastname;

    @Column(name = "class_name", nullable = false)
    private  String classname;

    @Column(name = "nationality", nullable = false)
    private  String nationality;
/*
    public Student(long id,String firstname,String lastname, String classname,String nationality){
        this.classname=classname;
        this.firstname=firstname;
        this.id=id;
        this.lastname=lastname;
        this.nationality=nationality;

    }*/

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString(){

        return "Student{" +
                "id=" +id+
                ",firstname='" +firstname+'\''+
                ",lastname" +lastname+'\''+
                "classname" +classname+'\''+
                "nationality" +nationality+'\''+
                '}';
    }
}
