package study.BrushUpOnSpring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.BrushUpOnSpring.AppConfig;
import study.BrushUpOnSpring.member.Grade;
import study.BrushUpOnSpring.member.Member;
import study.BrushUpOnSpring.member.MemberService;
import study.BrushUpOnSpring.member.MemberServiceImpl;

public class OrderServiceTest {

//    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;
//    OrderService orderService = new OrderServiceImpl();
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
