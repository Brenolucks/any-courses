package brenolucks.anycourses.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_professor")
public class Professor extends User {
    @Column(name = "professor_description")
    private String professorDescription;
    @OneToMany(mappedBy = "professor")
    private List<Courses> courses;
}
