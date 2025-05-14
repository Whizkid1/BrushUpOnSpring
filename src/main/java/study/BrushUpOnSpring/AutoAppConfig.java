package study.BrushUpOnSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import study.BrushUpOnSpring.member.MemberRepository;
import study.BrushUpOnSpring.member.MemoryMemberRepository;

@Configuration
@ComponentScan( // @Component 가 붙어있는 클래스를 모두 스캔해서 자동으로 spring bean으로 등록
        // 수동으로 등록한 config class들 제외 -> ex) AppConfig.class
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // 자동 빈 & 수동 빈 중복 등록 테스트
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
