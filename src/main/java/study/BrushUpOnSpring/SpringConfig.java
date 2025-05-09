package study.BrushUpOnSpring;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.BrushUpOnSpring.repository.*;
import study.BrushUpOnSpring.service.MemberService;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final EntityManager em; //JPA 사용을 위한 추가

    @Autowired
    //public SpringConfig(DataSource dataSource) {
    public SpringConfig(DataSource dataSource, EntityManager em) { //JPA 사용을 위한 추가
        this.dataSource = dataSource;
        this.em = em; //JPA 사용을 위한 추가
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);

    }
}
