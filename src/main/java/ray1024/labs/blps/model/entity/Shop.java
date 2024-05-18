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
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String address;

    @ManyToMany
    @JoinTable(name = "shop_item",
            joinColumns = @JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false))
    private List<Item> items;
}
