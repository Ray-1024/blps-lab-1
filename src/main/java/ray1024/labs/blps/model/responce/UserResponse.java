package ray1024.labs.blps.model.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ray1024.labs.blps.model.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {
    private User user;
}
