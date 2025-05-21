package study.BrushUpOnSpring.web.frontcontroller.v4.controller;

import study.BrushUpOnSpring.domain.member.Member;
import study.BrushUpOnSpring.domain.member.MemberRepository;
import study.BrushUpOnSpring.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {

    MemberRepository memberRepository = MemberRepository.getInstance();
    // v3 코드
//    @Override
//    public ModelView process(Map<String, String> paramMap) {
//
//        List<Member> members = memberRepository.findAll();
//
//        ModelView mv = new ModelView("members");
//        mv.getModel().put("members", members);
//        return mv;
//    }
    // v4 -> ModelView 제거, 논리적 viewPathName 반환
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);

        return "members";
    }
}
