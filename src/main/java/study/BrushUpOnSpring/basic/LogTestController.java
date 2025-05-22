package study.BrushUpOnSpring.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController -> REST API controller 약자
// @Controller 처럼 ViewResolver 찾는 과정 없이 return 형식에 맞춰서 그대로 전달
// @Slf4j 애노테이션으로 라이브러리 호출을 하지 않아도 됨!!!!
@Slf4j
@RestController
public class LogTestController {

    // 두개 모두 동일한 코드
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {

        String name = "Spring";
        System.out.println("name = " + name);
        // 시간 INFO 66243 --- [BrushUpOnSpring] [nio-8080-exec-4] s.B.basic.LogTestController : info log=Spring 출력
        log.info("info log={}", name);

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);
        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
        // "+" 연사자 때문에 출력이 되지 않아도 메모리를 사용하게 됨, 결과는 같지만....
        // 실무에서 절대 지양해야할 log codding
        log.debug("String concat log=" + name);
        log.debug("debug log=" + name);

        return "OK";
    }
}
