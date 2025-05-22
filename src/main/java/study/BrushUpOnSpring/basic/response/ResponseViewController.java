package study.BrushUpOnSpring.basic.response;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello"; //반환을 void로 진행할 수 있음, 하지만 명시성이 떨어져 권장하지 않음
    }

    @RequestMapping("/response/hello") // 권장하지 않음!!!!!!!!!!! 명시성이 너무 떨어짐
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }
}
