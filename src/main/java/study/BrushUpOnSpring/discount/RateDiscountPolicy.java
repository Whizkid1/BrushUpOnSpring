package study.BrushUpOnSpring.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import study.BrushUpOnSpring.member.Grade;
import study.BrushUpOnSpring.member.Member;

@Component
@Primary
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
