package study.BrushUpOnSpring.domain.item;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
// 강의와 다르게 실행 안됨 -> 라이브러리 추가 설치, 하지만 강사님이 비추천 하는 방식
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000",
//        message = "상품의 가격 * 수량의 합은 10000원 이상이어야 합니다.")
public class ItemV3 {

    @NotNull(groups = UpdateCheck.class) // 수정 요구사항 추가
    private Long id;

    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class})
//    @NotBlank(message = "메세지 커스텀 가능") //errors.properties 에 설정한 문구가 더 우선순위
    private String itemName;

    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    @Range(min = 1000, max = 1000000, groups = {SaveCheck.class, UpdateCheck.class}) // 표준에는 Range가 없음 -> spring 기능
    private Integer price;

    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    @Max(value = 9999, groups = {SaveCheck.class}) // 수정 요구사항 추가
    private Integer quantity;

    public ItemV3() {
    }

    public ItemV3(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
