package site.metacoding.everytimeclone.web.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.everytimeclone.domain.timetable.Timetable;
import site.metacoding.everytimeclone.service.TimetableService;

@RequiredArgsConstructor
@RestController
public class TimetableApiController {

    private final TimetableService timetableService;

    @GetMapping("/s/api/user/{id}/timetable")
    public ResponseEntity<?> calculator(@PathVariable Integer id) {

        List<Timetable> timetables = timetableService.시간표불러오기(id);

        return new ResponseEntity<>(timetables, HttpStatus.OK);
    }

}
