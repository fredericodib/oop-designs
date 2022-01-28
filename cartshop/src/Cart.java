import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Cart {
    private final Map<UUID, ItemCart> items;
    private final Map<UUID, Integer> sellerPrice;
    private Integer price;

    public Cart() {
        this.items = new HashMap<>();
        this.sellerPrice = new HashMap<>();
        this.price = 0;
    }

    public void insert(Item item, Integer quantity) {
        if (items.containsKey(item.getItemId())) {
            updateItemQuantity(item, quantity);
        } else {
            storeNewItem(item, quantity);
        }

        updatePrice(item, quantity);
    }

    public void insert(Item item) {
        insert(item, 1);
    }

    public void remove(Item item, Integer quantity) {
        if (!items.containsKey(item.getItemId()) || items.get(item.getItemId()).getQuantity() < quantity) {
            throw new RuntimeException("Operation not allowed");
        }

        if (items.get(item.getItemId()).getQuantity().equals(quantity)) {
            items.remove(item.getItemId());
        } else {
            updateItemQuantity(item, -quantity);
        }

        updatePrice(item, -quantity);
    }

    public void remove(Item item) {
        remove(item, 1);
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getSellerPrice(UUID sellerId) {
        return sellerPrice.get(sellerId);
    }


    private void storeNewItem(Item item, Integer quantity) {
        items.put(item.getItemId(), new ItemCart(item, quantity));
    }

    private void updateItemQuantity(Item item, Integer quantity) {
        items.get(item.getItemId()).increaseQuantity(quantity);
    }

    private void updatePrice(Item item, Integer quantity) {
        Integer addValue = item.getValor() * quantity;
        if (sellerPrice.containsKey(item.getSellerId())) {
            sellerPrice.put(item.getSellerId(), sellerPrice.get(item.getSellerId()) + addValue);
        } else {
            sellerPrice.put(item.getSellerId(), addValue);
        }

        price += addValue;
    }
}
