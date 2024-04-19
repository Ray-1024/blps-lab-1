package ray1024.labs.blps.mapper;

import org.mapstruct.Mapper;
import ray1024.labs.blps.model.dto.UserDto;
import ray1024.labs.blps.model.entity.UserEntity;

@Mapper
public interface UserMapper {
    UserDto toDto(UserEntity entity);
}
