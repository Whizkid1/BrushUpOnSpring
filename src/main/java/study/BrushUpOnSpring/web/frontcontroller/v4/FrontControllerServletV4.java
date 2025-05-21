package study.BrushUpOnSpring.web.frontcontroller.v4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.BrushUpOnSpring.web.frontcontroller.MyView;
import study.BrushUpOnSpring.web.frontcontroller.v4.controller.MemberFormControllerV4;
import study.BrushUpOnSpring.web.frontcontroller.v4.controller.MemberListControllerV4;
import study.BrushUpOnSpring.web.frontcontroller.v4.controller.MemberSaveControllerV4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

///front-controller/v1/ 의 어떤 하위 경로가 호출되도 FrontControllerServletV1 servlet 이 먼저 호출된다.
@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerMap.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        ControllerV4 controller = controllerMap.get(requestURI); // 인터페이스 다형성을 활용
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(request);
        // v4 코드 추가
        Map<String, Object> model = new HashMap<>();
        // v3 -> v4
//        ModelView mv = controller.process(paramMap);
//        String viewName = mv.getViewName();
        String viewName = controller.process(paramMap, model);

        MyView view = viewResolver(viewName);

        // v3 -> v4
//        view.render(mv.getModel(), request, response);
        view.render(model, request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paraName -> paramMap.put(paraName, request.getParameter(paraName)));
        return paramMap;
    }
}
