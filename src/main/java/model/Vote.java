package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="votes")
public class Vote {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "global_seq"
    )
    @SequenceGenerator(
            name = "global_seq",
            allocationSize = 1
    )
    private int id;

    @Column(name="date")
    private LocalDateTime date;

    @Column(name="rest_id")
    private int rest_id;

    @Column(name="username")
    private String username;
}
