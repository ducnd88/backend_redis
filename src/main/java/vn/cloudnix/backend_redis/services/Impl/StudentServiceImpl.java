package vn.cloudnix.backend_redis.services.Impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.cloudnix.backend_redis.entiry.Student;
import vn.cloudnix.backend_redis.model.StudentRequest;
import vn.cloudnix.backend_redis.model.StudentResponse;
import vn.cloudnix.backend_redis.repository.StudentRepository;
import vn.cloudnix.backend_redis.services.StudentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentResponse addNewStudent(StudentRequest studentRequest) {
        Student student = new Student();
        BeanUtils.copyProperties(studentRequest,student);
        studentRepository.save(student);
        StudentResponse studentResponse = new StudentResponse();
        BeanUtils.copyProperties(student, studentResponse);
        return studentResponse;
    }

    @Override
    public StudentResponse getStudentById(Integer id) {
        Student student = studentRepository.findById(id).get();
        StudentResponse studentResponse = new StudentResponse();
        BeanUtils.copyProperties(student, studentResponse);
        return studentResponse;
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentResponse> listAllStudents() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        List<StudentResponse> studentResponseList = new ArrayList<>();
        students.forEach(student -> {
            StudentResponse studentResponse = new StudentResponse();
            BeanUtils.copyProperties(student,studentResponse);
            studentResponseList.add(studentResponse);
        });
        return studentResponseList;
    }
}
