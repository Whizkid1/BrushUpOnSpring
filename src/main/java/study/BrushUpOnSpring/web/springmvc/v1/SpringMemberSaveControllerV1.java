package study.BrushUpOnSpring.web.springmvc.v1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import study.BrushUpOnSpring.domain.member.Member;
import study.BrushUpOnSpring.domain.member.MemberRepository;

import java.util.Map;

@Controller
public class SpringMemberSaveControllerV1 {

    MemberRepository memberRepository = MemberRepository.getInstance(); //singleton 방식

//    @Override
//    public ModelView process(Map<String, String> paramMap) {
    @RequestMapping("springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
//        String username = paramMap.get("username");
//        int age = Integer.parseInt(paramMap.get("age"));
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
//        mv.getModel().put("member", member);
        mv.addObject("member", member);
        return mv;
    }
}
