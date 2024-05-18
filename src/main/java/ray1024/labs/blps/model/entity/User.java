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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @OneToMany(mappedBy = "user")
    private List<Client> clients;

    @OneToMany(mappedBy = "user")
    private List<Packer> packers;

    @OneToMany(mappedBy = "user")
    private List<Courier> couriers;
}
