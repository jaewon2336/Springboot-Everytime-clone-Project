package site.metacoding.everytimeclone.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String professorList() {
        return "/admin/professorList";
    }

    // api로 고치기
    @GetMapping("/s/api/admin/professor")
    public ResponseEntity<?> professorListData() {
        List<Professor> professors = professorService.교수목록();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }

    @PostMapping("/s/admin/add-professor")
    public String addCourse(Professor professor) {
        professorService.교수등록(professor);
        return "redirect:/s/admin/professor-list";
    }

    @DeleteMapping("/s/admin/professor/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable Integer id) {
        professorService.교수삭제(id);
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

}
