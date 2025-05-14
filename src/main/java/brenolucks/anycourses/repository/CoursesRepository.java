package brenolucks.anycourses.repository;

import brenolucks.anycourses.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> {
}
