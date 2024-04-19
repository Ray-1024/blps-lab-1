package ray1024.labs.blps.model.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import ray1024.labs.blps.model.Order;
import ray1024.labs.blps.model.User;

import java.util.List;

@AllArgsConstructor
@Data
public class UserOrdersResponce {
    private User user;
    private List<Order> orders;
}

