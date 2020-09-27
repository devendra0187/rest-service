package com.example.restservice.Controller;

import com.example.restservice.model.Student;
import com.example.restservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentsById(@PathVariable(value = "id") Long Id){

        return studentRepository.findById(Id).get();
    }


    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {

        return studentRepository.save(student);
    }


    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable(value = "id") Long Id, @Valid @RequestBody Student studentDetails) {

        studentDetails.setFirstname(studentDetails.getFirstname());
        studentDetails.setLastname(studentDetails.getLastname());
        studentDetails.setClassname(studentDetails.getClassname());
        studentDetails.setNationality(studentDetails.getNationality());
        final Student updatedStudent = studentRepository.save(studentDetails);
        return studentRepository.save(studentDetails);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable(value = "id") Long Id) {
        studentRepository.deleteById(Id);

}
}
