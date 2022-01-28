import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Item {
    private UUID itemId;
    private UUID sellerId;
    private String name;
    private Integer valor;
}
