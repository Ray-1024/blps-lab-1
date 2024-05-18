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

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "packer_id", referencedColumnName = "id", nullable = false)
    private Packer packer;

    @ManyToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id", nullable = false)
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false)
    private Shop shop;

    @ManyToMany
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false))
    private List<Item> items;
}
