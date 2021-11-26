package id.actualtraining.restwithjpa.service;

import id.actualtraining.restwithjpa.entity.Course;
import id.actualtraining.restwithjpa.entity.Student;

import java.util.List;

public interface StudentService extends CRUD<Student> {
    public void RegisterStudentToCourse(Long studentid, List<Course> courses);
    public void RegisterStudentToCourseSingle(Long studentid,Course course);
}
