package study.BrushUpOnSpring.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.BrushUpOnSpring.discount.FixDiscountPolicy;
import study.BrushUpOnSpring.member.Grade;
import study.BrushUpOnSpring.member.Member;
import study.BrushUpOnSpring.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}