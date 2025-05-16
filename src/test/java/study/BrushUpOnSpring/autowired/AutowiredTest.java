package study.BrushUpOnSpring.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import study.BrushUpOnSpring.AutoAppConfig;
import study.BrushUpOnSpring.member.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
//        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
    }


    static class TestBean {
//        @Autowired(required = true) // default
        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("setNoBean1 = " + member); //자동 주입할 대상이 없어 메서드 자체가 실행 X
        }
        //null 호출
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("setNoBean2 = " + member);
        }
        //Optional.empty 호출
        @Autowired(required = false)
        public void setNoBean3(Optional<Member> member) {
            System.out.println("setNoBean3 = " + member);
        }
    }
}
