package ray1024.labs.blps.mapper;

import org.mapstruct.Mapper;
import ray1024.labs.blps.model.dto.ShopDto;
import ray1024.labs.blps.model.entity.ShopEntity;

@Mapper
public interface ShopMapper {
    ShopDto toDto(ShopEntity entity);
}
