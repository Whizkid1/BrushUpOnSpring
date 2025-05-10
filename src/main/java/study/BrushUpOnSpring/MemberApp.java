package study.BrushUpOnSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.BrushUpOnSpring.member.Grade;
import study.BrushUpOnSpring.member.Member;
import study.BrushUpOnSpring.member.MemberService;
import study.BrushUpOnSpring.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        /**
        AppConfig appConfig = new AppConfig();
//        MemberService memberService = new MemberServiceImpl();
        MemberService memberService = appConfig.memberService();
        */
        // Spring 으로 전환하기
        // ApplicationContext = 스프링 컨테이너
        // 스프링 컨테이너는 @Configuration 이 붙은 설정(구성) 정보를 사용
        // @Bean 이 붙은 메서드를 모두 호출&객체 생성(등록)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // @Bean 관리자에서 method 이름을 통해 생성
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}

