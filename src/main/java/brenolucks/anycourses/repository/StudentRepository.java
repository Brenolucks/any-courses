package brenolucks.anycourses.repository;

import brenolucks.anycourses.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
