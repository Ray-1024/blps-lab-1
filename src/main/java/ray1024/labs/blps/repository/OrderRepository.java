package ray1024.labs.blps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ray1024.labs.blps.model.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByClientId(Long clientId);

    List<Order> findAllByPackerId(Long packerId);

    List<Order> findAllByCourierId(Long courierId);

    Optional<Order> findAnyByShopIdAndPackerIsNull(Long shopId);

    Optional<Order> findAnyByCourierIsNull();

}
