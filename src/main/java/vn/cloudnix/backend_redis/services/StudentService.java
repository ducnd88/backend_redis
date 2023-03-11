package vn.cloudnix.backend_redis.services;

import vn.cloudnix.backend_redis.model.StudentRequest;
import vn.cloudnix.backend_redis.model.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse addNewStudent(StudentRequest studentRequest);

    StudentResponse getStudentById(Integer id);

    void deleteStudent(Integer id);

    List<StudentResponse> listAllStudents();
}
