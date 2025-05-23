package study.BrushUpOnSpring.domain.item;


import lombok.Data;

//@Getter @Setter // 핵심 도메인 모델은 이렇게 분리해서 사용하는 것을 권장
@Data // 핵심 도메인 모델은 @Data 사용을 지양 !!!! 예측하지 못하게 동작하는 경우가 있음
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
