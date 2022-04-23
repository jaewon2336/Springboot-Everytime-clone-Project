package site.metacoding.everytimeclone.web.api.dto.timetable;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.everytimeclone.domain.course.Course;
import site.metacoding.everytimeclone.domain.professor.Professor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimetableResDto {
    private List<Course> courses;
    private List<Professor> professors;
}
