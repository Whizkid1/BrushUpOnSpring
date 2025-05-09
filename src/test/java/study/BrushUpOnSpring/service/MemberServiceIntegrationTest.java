package study.BrushUpOnSpring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.BrushUpOnSpring.domain.Member;
import study.BrushUpOnSpring.repository.MemberRepository;
import study.BrushUpOnSpring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // Testcase에 달면 test 실행 시 1.트랜잭션 실행 2.DB에 쿼리를 다 넣고 3.test가 끝나면 롤백을 진행(반영을 안함)
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    // 이 방식이 dependency injection 중 한가지 방식

    @Test
    void 회원가입() {
        //given 뭔가가 주어줬는데
        Member member = new Member();
        member.setName("spring");

        //when 이걸 실행했을 떄
        Long saveId = memberService.join(member);

        //then 결과가 이제 나와야해
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        // when
        memberService.join(member1);
//        try {
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // then
    }
}