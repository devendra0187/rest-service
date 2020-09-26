package com.example.restservice.Controller;

import com.example.restservice.exception.ResourseNotFoundException;
import com.example.restservice.model.Student;
import com.example.restservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentsById(@PathVariable(value = "id") Long Id)throws ResourseNotFoundException.ResourceNotFoundException {
        Student student =
                studentRepository
                        .findById(Id)
                        .orElseThrow(() -> new ResourseNotFoundException.ResourceNotFoundException("User not found on :: " + Id));

        return studentRepository.findById(Id).get();
    }


    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {

        return studentRepository.save(student);
    }


    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable(value = "id") Long Id, @Valid @RequestBody Student studentDetails)
            throws ResourseNotFoundException.ResourceNotFoundException {

        Student user =
                studentRepository
                        .findById(Id)
                        .orElseThrow(() -> new ResourseNotFoundException.ResourceNotFoundException("User not found on :: " + Id));


        studentDetails.setFirstname(studentDetails.getFirstname());
        studentDetails.setLastname(studentDetails.getLastname());
        studentDetails.setClassname(studentDetails.getClassname());
        studentDetails.setNationality(studentDetails.getNationality());
        final Student updatedStudent = studentRepository.save(studentDetails);
        return studentRepository.save(studentDetails);
    }

    @DeleteMapping("/student/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId) throws Exception {
        Student student =
                studentRepository
                        .findById(studentId)
                        .orElseThrow(() -> new ResourseNotFoundException.ResourceNotFoundException("User not found on :: " + studentId));

        studentRepository.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
