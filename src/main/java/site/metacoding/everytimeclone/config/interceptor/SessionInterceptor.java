package site.metacoding.everytimeclone.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import site.metacoding.everytimeclone.domain.user.User;
import site.metacoding.everytimeclone.handler.ex.CustomPageException;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        HttpSession session = request.getSession();
        User principal = (User) session.getAttribute("principal");

        if (principal == null) {
            throw new CustomPageException("인증에 실패하였습니다.");
        } else {
            return true;
        }

    }
}
