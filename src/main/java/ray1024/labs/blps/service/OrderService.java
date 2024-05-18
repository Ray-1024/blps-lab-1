package ray1024.labs.blps.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.model.entity.*;
import ray1024.labs.blps.repository.OrderRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientService clientService;
    private final ShopService shopService;

    public Order createOrder(User user, Shop shop, List<Item> items) {
        Client client = clientService.getByUserId(user);
        if (!shopService.containsAllItems(shop, items))
            Order order = new Order();
        order.setShop(shop);
        order.setClient(client);
        order.setItems(items);
        return orderRepository.save(order);
    }

}
