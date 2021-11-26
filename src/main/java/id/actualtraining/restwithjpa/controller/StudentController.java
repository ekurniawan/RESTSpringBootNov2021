package id.actualtraining.restwithjpa.controller;

import id.actualtraining.restwithjpa.entity.Course;
import id.actualtraining.restwithjpa.entity.Student;
import id.actualtraining.restwithjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return   studentService.GetAll();
    }

    @PostMapping("/register/{id}")
    public void registerStudentToCourse(@PathVariable Long id,
                                        @RequestBody List<Course> courses){
        studentService.RegisterStudentToCourse(id,courses);
    }

    /*@PostMapping("/register/{id}")
    public void registerStudentToCourse(@PathVariable Long id,
                                        @RequestBody Course course){
        studentService.RegisterStudentToCourseSingle(id,course);
    }*/
}
