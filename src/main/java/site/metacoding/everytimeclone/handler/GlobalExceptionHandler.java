package site.metacoding.everytimeclone.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import site.metacoding.everytimeclone.handler.ex.CustomApiException;
import site.metacoding.everytimeclone.handler.ex.CustomException;
import site.metacoding.everytimeclone.handler.ex.CustomPageException;
import site.metacoding.everytimeclone.util.Script;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(Exception e) { // fetch 요청시 발동
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomException.class)
    public @ResponseBody String htmlException(Exception e) { // 일반적인 요청 Get(a태그), Post(form태그) 요청
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(CustomPageException.class)
    public String htmlPageException(Exception e) { // 일반적인 요청 Get(a태그), Post(form태그) 요청
        return "redirect:/user/login-form";
    }
}