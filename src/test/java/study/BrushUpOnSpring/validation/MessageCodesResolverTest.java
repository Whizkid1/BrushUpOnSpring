package study.BrushUpOnSpring.validation;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import org.springframework.validation.DefaultMessageCodesResolver;
import org.springframework.validation.MessageCodesResolver;

import static org.assertj.core.api.Assertions.assertThat;

public class MessageCodesResolverTest {

    MessageCodesResolver codesResolver = new DefaultMessageCodesResolver();

    @Test
    void messageCodesResolverObject() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required", "item");
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        assertThat(messageCodes).containsExactly("required.item", "required");
    }

    @Test
    void messageCodesResolverField() {
        String[] messageCodes = codesResolver.resolveMessageCodes("required",
                "item", "itemName", String.class);
        for (String messageCode : messageCodes) {
            System.out.println("messageCode = " + messageCode);
        }
        assertThat(messageCodes).containsExactly( // 밑으로 갈수록 디테일이 덜하다.(level이 낮다, 범용성은 올라간다.)
                "required.item.itemName",
                "required.itemName",
                "required.java.lang.String",
                "required"
        );
    }
}
