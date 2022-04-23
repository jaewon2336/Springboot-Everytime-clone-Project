package site.metacoding.everytimeclone.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimetableController {

    @GetMapping("/timetable")
    public String timetable() {
        return "timetable/timetable";
    }
}
