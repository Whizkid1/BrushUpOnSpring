package study.BrushUpOnSpring.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //@Component 내장 -> @ComponentScan 대상
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); // static 주의!! 실무에서는 HashMap XX -> 비동기, 멀티 등 고려
    private static long sequence = 0L; // 또한 위와 같은 이유로 AtomicLong 등을 사용, 위는 ConcurrentHashMap

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long id, Item updateParam) { // 원래는(규모가 커질수록) DTO 를 사용하는 것이 맞음
        Item findItem = findById(id);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() { // test 용 메서드
        store.clear();
    }
}
