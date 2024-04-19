package ray1024.labs.blps.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private UserDto customer;
    private List<ItemDto> items;
    private CourierDto courier;
}
