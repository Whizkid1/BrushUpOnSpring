package study.BrushUpOnSpring.web.frontcontroller.v3.controller;

import study.BrushUpOnSpring.domain.member.Member;
import study.BrushUpOnSpring.domain.member.MemberRepository;
import study.BrushUpOnSpring.web.frontcontroller.ModelView;
import study.BrushUpOnSpring.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance();

//    @Override
//    public MyView process(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        List<Member> members = memberRepository.findAll();
//
//        request.setAttribute("members", members);
//        //v1 코드
//        /*String viewPath = "/WEB-INF/views/members.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);*/
//        //v2 코드
//        return new MyView("/WEB-INF/views/members.jsp");
//    }

    @Override
    public ModelView process(Map<String, String> paramMap) {

        List<Member> members = memberRepository.findAll();

        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
