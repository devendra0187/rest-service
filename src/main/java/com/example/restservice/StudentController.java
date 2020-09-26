package com.example.restservice;

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
    public ResponseEntity<Object> getStudentsById(@PathVariable(value = "id") Long studentId)throws ResourseNotFoundException.ResourceNotFoundException {
        Student student =
                studentRepository
                        .findById(studentId)
                        .orElseThrow(() -> new ResourseNotFoundException.ResourceNotFoundException("User not found on :: " + studentId));

        return ResponseEntity.ok().body(studentId);
    }

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }

    /**
     * Update user response entity.
     *
     * @param userId the user id
     * @param userDetails the user details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId, @Valid @RequestBody Student studentDetails)
            throws ResourseNotFoundException.ResourceNotFoundException {

        Student user =
                studentRepository
                        .findById(studentId)
                        .orElseThrow(() -> new ResourseNotFoundException.ResourceNotFoundException("User not found on :: " + studentId));


        studentDetails.setFirstname(studentDetails.getFirstname());
        studentDetails.setLastname(studentDetails.getLastname());
        studentDetails.setClassname(studentDetails.getClassname());
        studentDetails.setNationality(studentDetails.getNationality());
        final Student updatedStudent = studentRepository.save(studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    /**
     * Delete user map.
     *
     * @param userId the user id
     * @return the map
     * @throws Exception the exception
     */
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
