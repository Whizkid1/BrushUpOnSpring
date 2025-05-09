package study.BrushUpOnSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.BrushUpOnSpring.domain.Member;
import study.BrushUpOnSpring.repository.MemberRepository;
import study.BrushUpOnSpring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional //**JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다!!
public class MemberService {
    
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final MemberRepository memberRepository;
    private MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
