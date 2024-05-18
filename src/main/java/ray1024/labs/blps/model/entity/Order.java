package ray1024.labs.blps.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    public enum Status {
        ORDERED, PACKED, DELIVERED, CANCELED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Packer packer;

    @ManyToOne
    private Courier courier;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Shop shop;

    @ManyToMany
    private List<Item> items;
}
