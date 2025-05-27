package study.BrushUpOnSpring.domain.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    void helloMessage() {
        // getMessage(code, args, locale(국가 언어))
        String result = ms.getMessage("hello", null, null);
        assertThat(result).isEqualTo("안녕");
    }

    @Test
    void notFoundMessageCode() {
        assertThatThrownBy(() -> ms.getMessage("no_code", null, null))
                .isInstanceOf(NoSuchMessageException.class);
    }
    @Test
    void notFoundMessageCodeDefaultMessage() {
        String result = ms.getMessage("no_code", null, "기본 메세지", null);
        assertThat(result).isEqualTo("기본 메세지");
    }

    @Test
    void argumentMessage() {
        String result = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
   //   String result = ms.getMessage("hello.name", "Spring", null); //ms.getMessage("no_code", null, "기본 메세지", null)
        assertThat(result).isEqualTo("안녕 Spring"); //대소문자, 띄어쓰기 간격 또한 맞춰야 함
    }

    @Test
    void defaultLang() {
        assertThat(ms.getMessage("hello", null, null)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.KOREAN)).isEqualTo("안녕"); //same
    }

    @Test
    void enLang() {
        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
        // 오류 안남.. args가 설정되지 않은 항목은 오류 X
        assertThat(ms.getMessage("hello", new Object[]{"Spring"}, Locale.ENGLISH)).isEqualTo("hello");
        // 당연히 오류 발생
//        assertThat(ms.getMessage("hello.name", new Object[]{"Spring"}, Locale.ENGLISH))
//                .isEqualTo("hello");
        assertThat(ms.getMessage("hello.name", new Object[]{"스프링"}, Locale.ENGLISH))
                .isEqualTo("hello 스프링");
    }

}
