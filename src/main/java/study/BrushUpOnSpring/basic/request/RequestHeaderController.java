package study.BrushUpOnSpring.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers( //인터페이스는 정형화 되지 않았지 떄문에 다양한 파라미터를 받을 수 있음
                           HttpServletRequest request,
                           HttpServletResponse response,
                           HttpMethod httpMethod,
                           Locale locale, //언어정보
                           @RequestHeader MultiValueMap<String, String> headerMap,
                           @RequestHeader("host") String host,
                           @CookieValue(value = "myCookie", required = false) String cookie
                           ) {
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale); // locale resolver 도 있으니 추가 공부 !! 로케일 리졸버를 통해 확장 가능
        log.info("headerMap={}", headerMap);
        log.info("header host={}", host);
        log.info("myCookie={}", cookie);
        return "ok";
    }
}
