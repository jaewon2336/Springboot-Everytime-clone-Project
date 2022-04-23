package site.metacoding.everytimeclone.web.api.dto.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.everytimeclone.domain.course.Course;
import site.metacoding.everytimeclone.domain.professor.Professor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCourseReqDto {

    private String name;
    private Integer point;
    private String professor;
    private String classroom;
    private String weekday;
    private Integer startTime;
    private Integer endTime;

    public Course toEntity(Professor professor) {
        Course course = new Course();
        course.setName(name);
        course.setPoint(point);
        course.setProfessor(professor);
        course.setWeekday(weekday);
        course.setClassroom(classroom);
        course.setStartTime(startTime);
        course.setEndTime(endTime);
        return course;
    }

}
