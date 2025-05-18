package brenolucks.anycourses.controller.CoursesController;

import brenolucks.anycourses.dto.CourseRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @PostMapping("/api/register/course")
    public ResponseEntity<String> createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Course created with success");
    }
}
