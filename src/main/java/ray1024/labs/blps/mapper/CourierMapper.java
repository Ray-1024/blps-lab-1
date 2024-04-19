package ray1024.labs.blps.mapper;

import org.mapstruct.Mapper;
import ray1024.labs.blps.model.dto.CourierDto;
import ray1024.labs.blps.model.entity.CourierEntity;

@Mapper
public interface CourierMapper {
    CourierDto toDto(CourierEntity entity);
}
