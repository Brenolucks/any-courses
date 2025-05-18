package brenolucks.anycourses.controller.VideoController;

import brenolucks.anycourses.dto.VideoRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VideoController {
    @PostMapping("/api/register/video")
    public ResponseEntity<String> addVideo(@RequestBody VideoRequestDTO videoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Video added with success");
    }
}
