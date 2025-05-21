package study.BrushUpOnSpring.web.frontcontroller.v3.controller;

import study.BrushUpOnSpring.web.frontcontroller.ModelView;
import study.BrushUpOnSpring.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
//    @Override
//    public MyView process(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        /*// v1 코드
//        String viewPath = "/WEB-INF/views/new-form.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);*/
//        //v2 코드
//        return new MyView("/WEB-INF/views/new-form.jsp");
//
//    }
    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }

}
