package ray1024.labs.blps.mapper;

import org.mapstruct.Mapper;
import ray1024.labs.blps.model.dto.OrderDto;
import ray1024.labs.blps.model.entity.OrderEntity;

@Mapper
public interface OrderMapper {
    OrderDto toDto(OrderEntity entity);
}
