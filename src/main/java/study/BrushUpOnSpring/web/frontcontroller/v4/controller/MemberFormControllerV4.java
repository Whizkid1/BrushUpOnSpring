package study.BrushUpOnSpring.web.frontcontroller.v4.controller;

import study.BrushUpOnSpring.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    // v3 코드
//    @Override
//    public ModelView process(Map<String, String> paramMap) {
//        return new ModelView("new-form");
//    }
    // v4 코두
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }

}
