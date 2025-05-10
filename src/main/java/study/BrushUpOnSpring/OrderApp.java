package study.BrushUpOnSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.BrushUpOnSpring.member.Grade;
import study.BrushUpOnSpring.member.Member;
import study.BrushUpOnSpring.member.MemberService;
import study.BrushUpOnSpring.member.MemberServiceImpl;
import study.BrushUpOnSpring.order.Order;
import study.BrushUpOnSpring.order.OrderService;
import study.BrushUpOnSpring.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();
//        // 사용영역과 구성영역 구분 -> 리팩토링 (DIP, OCP 위반 해결)
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        // spring 으로 전환
        // ApplicationContext = 스프링 컨테이너
        // 스프링 컨테이너는 @Configuration 이 붙은 설정(구성) 정보를 사용
        // @Bean 이 붙은 메서드를 모두 호출&객체 생성(등록)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println(order);
        System.out.println(order.calculatePrice());

    }
}
