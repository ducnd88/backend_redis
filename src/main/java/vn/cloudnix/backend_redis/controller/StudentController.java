package vn.cloudnix.backend_redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.cloudnix.backend_redis.model.StudentRequest;
import vn.cloudnix.backend_redis.model.StudentResponse;
import vn.cloudnix.backend_redis.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public StudentResponse addNewStudent(@RequestBody StudentRequest studentRequest){
        return studentService.addNewStudent(studentRequest);
    }

    @GetMapping("/getStudent/{id}")
    public StudentResponse getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAllStudents")
    List<StudentResponse> getAllStudent(){
        return studentService.listAllStudents();
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudentById(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
