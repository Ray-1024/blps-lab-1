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
    @Column(name = "shop_id")
    private Long shop_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String address;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Item> items;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private List<Packer> packers;

}
