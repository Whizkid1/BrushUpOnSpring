package study.BrushUpOnSpring.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.BrushUpOnSpring.discount.DiscountPolicy;
import study.BrushUpOnSpring.discount.FixDiscountPolicy;
import study.BrushUpOnSpring.discount.RateDiscountPolicy;
import study.BrushUpOnSpring.member.Member;
import study.BrushUpOnSpring.member.MemberRepository;
import study.BrushUpOnSpring.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService{

    /**
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // DIP 위반: DiscountPolicy 의존하고 있지만, 구현체들도 의존하고 있음 !!
    // OCP 위반: 구현체 변경을 위해 OrderServiceImpl 소스 코드(클라이언트 코드) 변경해야함 !!!
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 위반 사항 여기서 해결 불가 -> 다른 곳에서 OrderServiceImpl 에 discountPolicy 의 구현 객체를 대신 생성해서 주입해주어야 함!!!!!
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;
     */
    // DIP, OCP 오류 해결 -> 생성자 주입
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
