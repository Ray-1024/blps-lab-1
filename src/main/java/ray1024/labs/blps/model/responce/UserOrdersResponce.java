package ray1024.labs.blps.model.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import ray1024.labs.blps.model.dto.OrderDto;
import ray1024.labs.blps.model.dto.UserDto;

import java.util.List;

@AllArgsConstructor
@Data
public class UserOrdersResponce {
    private UserDto user;
    private List<OrderDto> orders;
}

