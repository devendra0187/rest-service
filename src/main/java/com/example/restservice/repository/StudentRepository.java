package com.example.restservice.repository;

import com.example.restservice.model.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}