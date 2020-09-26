package com.example.restservice;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}