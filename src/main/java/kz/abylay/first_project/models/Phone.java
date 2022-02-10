package kz.abylay.first_project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "telefony")
public class Phone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iphone_id")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private int amount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;
}
