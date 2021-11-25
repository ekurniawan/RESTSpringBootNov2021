package id.actualtraining.restwithjpa.repository;

import id.actualtraining.restwithjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
