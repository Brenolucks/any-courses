package brenolucks.anycourses.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record ErrorResponseDTO (int status, String message, String field,
                                @JsonFormat(pattern="yyyy-MM-dd")
                                LocalDateTime time) {
}
