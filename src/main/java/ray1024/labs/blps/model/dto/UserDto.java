package ray1024.labs.blps.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ray1024.labs.blps.model.entity.RoleEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String login;
    private String password;
    private RoleEntity roleEntity;
}
