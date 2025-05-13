package brenolucks.anycourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_course", nullable = false, unique = true)
    private String nameCourse;
    @Column(name = "description_course")
    private String descriptionCourse;
    @Column(name = "total_students")
    private int totalStudents;
    @Column(name = "duration_course")
    private int duration;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
    @ManyToMany
    @JoinColumn(name = "videos_id")
    private List<Videos> videos;
}
