package site.metacoding.everytimeclone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.professor.Professor;
import site.metacoding.everytimeclone.domain.professor.ProfessorRepository;

@RequiredArgsConstructor
@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public Professor 교수찾기(String name) {
        Optional<Professor> professorOp = professorRepository.findByName(name);
        if (professorOp.isPresent()) {
            return professorOp.get();
        } else {
            return null;
        }
    }

    public void 교수등록(Professor professor) {
        professorRepository.save(professor);
    }

    public List<Professor> 교수목록() {
        return professorRepository.findAll();
    }
}
