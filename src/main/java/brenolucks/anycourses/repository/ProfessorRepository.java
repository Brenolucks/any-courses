package brenolucks.anycourses.repository;

import brenolucks.anycourses.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
