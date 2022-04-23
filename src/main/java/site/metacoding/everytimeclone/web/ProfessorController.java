package site.metacoding.everytimeclone.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.professor.Professor;
import site.metacoding.everytimeclone.service.ProfessorService;

@RequiredArgsConstructor
@Controller
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("/s/admin/add-professor")
    public String addProfessor() {
        return "/admin/addProfessor";
    }

    @GetMapping("/s/admin/professor-list")
    public String courseList(Model model) {
        List<Professor> professors = professorService.교수목록();
        model.addAttribute("professors", professors);
        return "/admin/professorList";
    }

    @PostMapping("/s/admin/add-professor")
    public String addCourse(Professor professor) {
        professorService.교수등록(professor);
        return "redirect:/s/admin/professor-list";
    }

}
