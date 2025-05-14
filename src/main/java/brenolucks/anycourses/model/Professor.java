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
@Entity
@Table(name = "tb_professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "professor_description")
    private String professorDescription;
    @OneToMany(mappedBy = "professor")
    private List<Courses> courses;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
