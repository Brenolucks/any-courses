package brenolucks.anycourses.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_student")
public class Student extends User {
    @Column(name = "student_description")
    private String studentDescription;
    @Column(name = "courses_done")
    private int coursesDone;
}
