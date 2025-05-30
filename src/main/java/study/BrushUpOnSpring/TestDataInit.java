package study.BrushUpOnSpring;

import jakarta.annotation.PostConstruct;
import study.BrushUpOnSpring.domain.item.Item;
import study.BrushUpOnSpring.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.BrushUpOnSpring.domain.member.Member;
import study.BrushUpOnSpring.domain.member.MemberRepository;


@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepository itemRepository;
    private final MemberRepository memberRepository;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));

        Member member = new Member();
        member.setLoginId("test");
        member.setPassword("test!");
        member.setName("테스터");
        memberRepository.save(member);
    }

}