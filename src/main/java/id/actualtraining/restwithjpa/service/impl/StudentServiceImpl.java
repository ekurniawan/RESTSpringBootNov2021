package id.actualtraining.restwithjpa.service.impl;

import id.actualtraining.restwithjpa.entity.Course;
import id.actualtraining.restwithjpa.entity.Student;
import id.actualtraining.restwithjpa.repository.StudentRepository;
import id.actualtraining.restwithjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> GetAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student GetById(Long id) {
        return null;
    }

    @Override
    public Student create(Student student) {
        return null;
    }

    @Override
    public Student update(Long id, Student student) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void RegisterStudentToCourse(Long studentid, List<Course> courses) {
        Optional<Student> student = studentRepository.findById(studentid);
        if(student.isPresent()){
            Student updStudent = student.get();
            updStudent.getCourses().addAll(courses);
            studentRepository.save(updStudent);
        }
    }
}
