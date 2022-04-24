package site.metacoding.everytimeclone.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.course.Course;
import site.metacoding.everytimeclone.domain.professor.Professor;
import site.metacoding.everytimeclone.service.CourseService;
import site.metacoding.everytimeclone.service.ProfessorService;
import site.metacoding.everytimeclone.web.api.dto.course.AddCourseReqDto;

@RequiredArgsConstructor
@Controller
public class CourseController {

    private final CourseService courseService;
    private final ProfessorService professorService;

    @GetMapping("/s/admin/add-course")
    public String addCourse() {
        return "/admin/addCourse";
    }

    @GetMapping("/s/admin/course-list")
    public String courseList(Model model) {
        List<Course> courses = courseService.강의목록();
        model.addAttribute("courses", courses);
        return "/admin/courseList";
    }

    @PostMapping("/s/admin/add-course")
    public String addCourse(AddCourseReqDto addCourseReqDto, Model model) {

        Professor professorEntity = professorService.교수찾기(addCourseReqDto.getProfessor());

        courseService.강의등록(addCourseReqDto.toEntity(professorEntity));

        return "redirect:/s/admin/course-list";
    }

    @DeleteMapping("/s/admin/course/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable Integer id) {
        courseService.강의삭제(id);
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

}
