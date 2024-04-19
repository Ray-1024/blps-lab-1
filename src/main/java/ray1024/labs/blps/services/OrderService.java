package ray1024.labs.blps.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.repository.OrderRepository;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
}
