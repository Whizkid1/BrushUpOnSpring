package study.BrushUpOnSpring.web.basic;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import study.BrushUpOnSpring.domain.item.Item;
import study.BrushUpOnSpring.domain.item.ItemRepository;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // final 멤버변수(들)를 자동으로 생성자 및 의존성 주입
public class BasicItemController {

    private final ItemRepository itemRepository;

//    @Autowired // 생략 가능
//    public BasicItemController(ItemRepository itemRepository) {
//        this.itemRepository = itemRepository;
//    }

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable("itemId") long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(@RequestParam("itemName") String itemName,
                       @RequestParam("price") int price,
                       @RequestParam("quantity") Integer quantity,
                       Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item", item);

        return "basic/item";
    }
//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item,
                            Model model) {
        itemRepository.save(item);
        // 주석처리 가능-> @ModelAttribute 기능 1.객체 자동 생성
        // 2. model.addAttribute 자동 등록 (단, 이름은 @ModelAttribute("이름") 의 "이름"으로 설정)
//        model.addAttribute("item", item);

        return "basic/item";
    }
//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item,
                            Model model) {
        itemRepository.save(item);

        return "basic/item";
    }
//    @PostMapping("/add")
    public String addItemV4(Item item,
                            Model model) {
        itemRepository.save(item);

//        return "basic/item"; // PRG 가 고려되지 않음
        return "redirect:/basic/items/" + item.getId(); // PRG는 고려. 하지만 URL 인코딩이 불가한 방식
    }
    @PostMapping("/add")
    public String addItemV6(Item item,
                            RedirectAttributes redirectAttributes) {
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        // redirectAttributes.addAttribute("itemId", savedItem.getId()); 에서 설정한 attributeName 이 {}와 mapping->값 전달
        return "redirect:/basic/items/{itemId}"; //
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }

    /**
     * 테스트용 데이터 추가
     * 이거 덕분에 상품들 목록 화면에 기본 상품으로 등록되어 보여짐
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }
}
