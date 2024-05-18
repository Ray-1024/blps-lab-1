package ray1024.labs.blps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ray1024.labs.blps.model.entity.Packer;

import java.util.Optional;

public interface PackerRepository extends JpaRepository<Packer, Long> {

    Optional<Packer> findByUserId(Long user);
}
