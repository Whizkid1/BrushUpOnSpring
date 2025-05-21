package study.BrushUpOnSpring.web.frontcontroller.v3.controller;

import study.BrushUpOnSpring.domain.member.Member;
import study.BrushUpOnSpring.domain.member.MemberRepository;
import study.BrushUpOnSpring.web.frontcontroller.ModelView;
import study.BrushUpOnSpring.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    MemberRepository memberRepository = MemberRepository.getInstance(); //singleton 방식

//    @Override
//    public MyView process(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));
//
//        Member member = new Member(username, age);
//        memberRepository.save(member);
//
//        //Model에 데이터를 보관한다.
//        //request 객체에 내부 임시보관소(map 같은)에 저장
//        request.setAttribute("member", member);
//
//        // v1 코드
//        /*String viewPath = "/WEB-INF/views/save-result.jsp";
//        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        dispatcher.forward(request, response);*/
//        // v2 코드
//        return new MyView("/WEB-INF/views/save-result.jsp");
//    }
    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;

    }
}
