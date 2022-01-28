import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ItemCart {
    Item item;
    Integer quantity;

    public void increaseQuantity(Integer quantity) {
        this.quantity += quantity;
    }
}
