package study.BrushUpOnSpring.web.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import study.BrushUpOnSpring.domain.item.Item;

@Component
public class ItemValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
        // item 타입 == clazz 타입
        // item 타입 == subItem(자식 클래스) 검증
    }

    @Override
    public void validate(Object target, Errors errors) {

        Item item = (Item) target; // supports 에서 검증했기 때문에 (다운)캐스팅 가능

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName", "required");

        if (item.getPrice() == null || item.getPrice() < 1000 || item.getPrice() > 1000000) {
            // Args를 빼먹게 되면 해당 문구의 파라미터 ex)"{1}" 가 그대로 출력
            errors.rejectValue("price", "range", new Object[]{1000, 1000000}, null);
        }
        if (item.getQuantity() == null || item.getQuantity() >= 9999) {
            errors.rejectValue("quantity", "max", new Object[]{9999}, null);
        }
        // 특정 필드가 아닌 복합 룰 검증
        if (item.getPrice() != null && item.getQuantity() != null) {
            int resultPrice  = item.getPrice() * item.getQuantity();
            if (resultPrice < 10000) {
                errors.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }

    }
}
