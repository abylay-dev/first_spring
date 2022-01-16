package kz.abylay.first_project.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone implements Serializable {
    private Integer id;
    private String name;
    private int price;
    private int amount;
}
