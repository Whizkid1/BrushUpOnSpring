package study.BrushUpOnSpring.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET) //메서드 설정이 없으면 메서드에 무관하게 호출해도 응답함
    public String helloBasic() {
        log.info("helloBasic");
        return "Ok";
    }

    /**
     * 편리한 축약 애노테이션 (코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mapping-get-v2");
        return "ok";
    }
    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable String userId
     */
    @GetMapping("/mapping/{userId}") // 괄호 안에 값이 없으면 호출 불가
    public String mappingPath(@PathVariable("userId") String data) {
//    public String mappingPath(@PathVariable String userId) { // 이렇게 사용해도 됨
//        String data = userId;
        log.info("mappingPath userId={}", data);
        return "Hello " + data;
    }
    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long
            orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }
    /**
     * 파라미터로 추가 매핑 -> 이 방식 자주 사용되지 않음
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     * 실행 http://localhost:8080/mapping-param?mode=debug
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug") // URL에 ?mode=debug 없으면 실행되지 않음-> ?{params value}
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    @GetMapping(value = "/mapping-header", headers = "mode=debug") // header 정보에 mode=debug 없으면 실행되지 않음
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    @PostMapping(value = "/mapping-consume", consumes = "application/json") //Content-Type 헤더 기반 추가 매핑 Media Type
    public String mappingConsume() {
        log.info("mappingConsumes");
        return "OK";
    }

    @PostMapping(value = "/mapping-produce", produces = "text/html") //Accept 헤더 기반 Media Type (client가 받을 수 있는 타입)
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
