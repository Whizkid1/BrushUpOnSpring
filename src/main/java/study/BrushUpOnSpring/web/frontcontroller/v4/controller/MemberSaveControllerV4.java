package study.BrushUpOnSpring.web.frontcontroller.v4.controller;

import study.BrushUpOnSpring.domain.member.Member;
import study.BrushUpOnSpring.domain.member.MemberRepository;
import study.BrushUpOnSpring.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {

    MemberRepository memberRepository = MemberRepository.getInstance(); //singleton 방식
    // v3 코드
//    @Override
//    public ModelView process(Map<String, String> paramMap) {
//        String username = paramMap.get("username");
//        int age = Integer.parseInt(paramMap.get("age"));
//
//        Member member = new Member(username, age);
//        memberRepository.save(member);
//
//        ModelView mv = new ModelView("save-result");
//        mv.getModel().put("member", member);
//        return mv;
//    }
    // v4 -> ModelView 제거, 논리적 viewPathName 반환
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);

        return "save-result";
    }
}
