package study.BrushUpOnSpring.web.springmvc.v3;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import study.BrushUpOnSpring.domain.member.Member;
import study.BrushUpOnSpring.domain.member.MemberRepository;

import java.util.List;
import java.util.SimpleTimeZone;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping("/new-form")
//    public ModelAndView newForm() {
//        return new ModelAndView("new-form");
//    }
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

//    @RequestMapping("/save")
//    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
//
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));
//
//        Member member = new Member(username, age);
//        memberRepository.save(member);
//
//        ModelAndView mv = new ModelAndView("save-result");
//        mv.addObject("member", member);
//        return mv;
//    }
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {
        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    @RequestMapping
    public ModelAndView members() {

        List<Member> members = memberRepository.findAll();

        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members", members);
        return mv;
    }
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
