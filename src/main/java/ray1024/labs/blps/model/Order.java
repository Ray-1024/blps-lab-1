package ray1024.labs.blps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private User customer;
    private List<Item> items;
    private Courier courier;
}
