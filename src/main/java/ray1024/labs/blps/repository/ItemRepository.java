package ray1024.labs.blps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ray1024.labs.blps.model.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {
}
