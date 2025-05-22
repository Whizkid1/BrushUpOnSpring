package study.BrushUpOnSpring.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import study.BrushUpOnSpring.basic.HelloData;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("OK");
    }

    // 이 방식을 권장!!!!!!!!!!!!!!!
    @ResponseBody  // @Controller + String(return type) -> viewResolver가 return 문자(논리적이름)에 맞는 것을 찾음. 그래서 사용
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge
    ) {
        log.info("username={}, age={}", memberName, memberAge);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username, // 변수명(클라 데이터) 과 파라미터 명이 동일 시 생략 가능 <- v2와 차이
            @RequestParam(required = true) int age) { // default = true, true 시 값이 들어오지 않으면 400 에러(bad request)
        // ++ int, float 등 기본형 타입은 null 이 불가능해서 required=false 사용하려면 Integer과 같은 객체형으로 등록
        // +++ String 중 ex) "?username=" 이렇게 요청을 날리면 null이 아닌 "" 빈문자로 값이 날라옴.. -> 주의 요망!!!
        log.info("username={}, age={}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4( // 단, 파라미터가 단순 타입(String, int 등)일 때만
            String username, // 변수명(클라 데이터) 과 파라미터 명이 동일 시 생략 가능, 심지어 @RequestParam 도 생략 가능 <- v3와 차이
            int age) {
        log.info("username={}, age={}", username, age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true) String username,
            @RequestParam(required = true, defaultValue = "32") int age) { //defaultValue 값을 문자열로 해야함!!!!!!!
        log.info("username={}, age={}", username, age);
        return "OK";
    }
    /**
     * @RequestParam Map, MultiValueMap
     * Map(key=value)
     * MultiValueMap(key=[value1, value2, ...]) ex) (key=userIds, value=[id1, id2]) 중요!!!!!!!!
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(
//            @RequestParam("username") String username,
//            @RequestParam("age") int age
            @ModelAttribute HelloData helloData) {
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData); //@Data 내장에 @ToString 기능이 탑재

        return "OK";
    }
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(
            HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData); //@Data 내장에 @ToString 기능이 탑재

        return "OK";
    }

}
