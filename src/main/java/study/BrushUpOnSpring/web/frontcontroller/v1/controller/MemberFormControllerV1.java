package study.BrushUpOnSpring.web.frontcontroller.v1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.BrushUpOnSpring.web.frontcontroller.v1.ControllerV1;

import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // MvcMemberFormServlet 의 코드를 그대로 사용
        // 컨트롤러에서 검증 후 View(JSP)로 보낼 경로 설정
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // controller -> view 로 요청 데이터 이동
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // servlet 에서 view 호출
        dispatcher.forward(request, response);
    }
}
