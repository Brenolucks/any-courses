package brenolucks.anycourses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_description")
    private String studentDescription;
    @Column(name = "courses_done")
    private int coursesDone;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
