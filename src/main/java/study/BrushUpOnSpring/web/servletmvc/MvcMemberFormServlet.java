package study.BrushUpOnSpring.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String viewPath = "/WEB-INF/views/new-form.jsp"; // 컨트롤러에서 검증 후 View(JSP)로 보낼 경로 설정

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// controller -> view 로 요청 데이터 이동
        dispatcher.forward(request, response); // servlet 에서 view 호출

    }
}
