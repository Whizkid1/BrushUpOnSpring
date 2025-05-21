package study.BrushUpOnSpring.web.frontcontroller.v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.BrushUpOnSpring.web.frontcontroller.MyView;

import java.io.IOException;

public interface ControllerV2 {

    //MyView 반환을 통해
    MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
