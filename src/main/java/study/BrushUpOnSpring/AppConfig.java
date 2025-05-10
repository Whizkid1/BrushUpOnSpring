package study.BrushUpOnSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.BrushUpOnSpring.discount.DiscountPolicy;
import study.BrushUpOnSpring.discount.FixDiscountPolicy;
import study.BrushUpOnSpring.discount.RateDiscountPolicy;
import study.BrushUpOnSpring.member.*;
import study.BrushUpOnSpring.order.OrderService;
import study.BrushUpOnSpring.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    // 역할과 구현을 명확하게 구분하고 가시성을 높이기 위해 리팩토링
//    public MemberService memberService() {
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//
//    public OrderService orderService() {
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//    }
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
