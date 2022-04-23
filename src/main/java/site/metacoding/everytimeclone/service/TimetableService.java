package site.metacoding.everytimeclone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.course.Course;
import site.metacoding.everytimeclone.domain.course.CourseRepository;
import site.metacoding.everytimeclone.domain.professor.Professor;
import site.metacoding.everytimeclone.domain.professor.ProfessorRepository;
import site.metacoding.everytimeclone.domain.timetable.Timetable;
import site.metacoding.everytimeclone.domain.timetable.TimetableRepository;
import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.web.api.dto.timetable.TimetableReqDto;
import site.metacoding.everytimeclone.web.api.dto.timetable.TimetableResDto;

@RequiredArgsConstructor
@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;
    private final CourseRepository courseRepository;
    private final ProfessorRepository professorRepository;

    public void 시간표등록(TimetableReqDto timetableReqDto, User principal) {
        Course courseEntity = null;
        Professor professorEntity = null;

        Optional<Course> courseOp = courseRepository.findByName(timetableReqDto.getCourseName());
        if (courseOp.isPresent()) {
            courseEntity = courseOp.get();
        }

        Optional<Professor> professorOp = professorRepository.findByName(timetableReqDto.getProfessorName());
        if (professorOp.isPresent()) {
            professorEntity = professorOp.get();
        }

        Timetable timetable = timetableReqDto.toEntity(courseEntity, professorEntity, principal);
        timetableRepository.save(timetable);
    }

    public TimetableResDto 시간표만들기() {
        // course 찾고 professor 찾아서 모델에 담아주기
        List<Course> courses = courseRepository.findAll();
        List<Professor> professors = professorRepository.findAll();

        TimetableResDto timetableResDto = new TimetableResDto();
        timetableResDto.setCourses(courses);
        timetableResDto.setProfessors(professors);
        return timetableResDto;
    }

    public List<Timetable> 시간표불러오기(Integer userId) {
        return timetableRepository.findByUserId(userId);
    }

}
