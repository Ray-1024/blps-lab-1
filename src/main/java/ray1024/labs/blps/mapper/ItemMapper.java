package ray1024.labs.blps.mapper;

import org.mapstruct.Mapper;
import ray1024.labs.blps.model.dto.ItemDto;
import ray1024.labs.blps.model.entity.ItemEntity;

@Mapper
public interface ItemMapper {
    ItemDto toDto(ItemEntity entity);
}
