package ray1024.labs.blps.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ray1024.labs.blps.model.entity.Role;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private String login;
    private String password;
    private Role roleEntity;
}
