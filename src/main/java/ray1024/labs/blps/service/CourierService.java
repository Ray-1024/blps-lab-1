package ray1024.labs.blps.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ray1024.labs.blps.repository.CourierRepository;

@Service
@AllArgsConstructor
public class CourierService {
    private final CourierRepository courierRepository;
}
