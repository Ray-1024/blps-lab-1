package ray1024.labs.blps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ray1024.labs.blps.model.entity.CourierEntity;

public interface CourierRepository extends JpaRepository<CourierEntity, String> {
}
