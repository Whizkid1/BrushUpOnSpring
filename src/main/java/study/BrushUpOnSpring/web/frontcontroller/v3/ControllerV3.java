package study.BrushUpOnSpring.web.frontcontroller.v3;

import study.BrushUpOnSpring.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    //v2 코드
    /*
    //MyView 반환을 통해
    MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
    */
    ModelView process(Map<String, String> paraMap);
}
