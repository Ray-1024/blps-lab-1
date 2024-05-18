package ray1024.labs.blps.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courier_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
