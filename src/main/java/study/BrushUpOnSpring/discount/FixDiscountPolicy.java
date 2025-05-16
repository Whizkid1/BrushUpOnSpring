package study.BrushUpOnSpring.discount;

import org.springframework.stereotype.Component;
import study.BrushUpOnSpring.member.Grade;
import study.BrushUpOnSpring.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private  int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) { //Enum type "==" 으로 비교
            return  discountFixAmount;
        }
        return 0;
    }
}
