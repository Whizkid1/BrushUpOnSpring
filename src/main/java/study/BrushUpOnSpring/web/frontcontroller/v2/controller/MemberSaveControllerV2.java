package study.BrushUpOnSpring.web.frontcontroller.v2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import study.BrushUpOnSpring.domain.member.Member;
import study.BrushUpOnSpring.domain.member.MemberRepository;
import study.BrushUpOnSpring.web.frontcontroller.MyView;
import study.BrushUpOnSpring.web.frontcontroller.v2.ControllerV2;

import java.io.IOException;

public class MemberSaveControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance(); //singleton 방식

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        //Model에 데이터를 보관한다.
        //request 객체에 내부 임시보관소(map 같은)에 저장
        request.setAttribute("member", member);

        // v1 코드
        /*String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);*/
        return new MyView("/WEB-INF/views/save-result.jsp");
    }
}
