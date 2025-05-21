package study.BrushUpOnSpring.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {

    // v3 코드
    // ModelView process(Map<String, String> paraMap);
    // v4 코드
    /**
     *
     * @param paramMap
     * @param model
     * @return viewName !!!!
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
