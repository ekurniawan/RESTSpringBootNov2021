package id.actualtraining.restwithjpa.repository;

import id.actualtraining.restwithjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
