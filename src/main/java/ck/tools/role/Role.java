package ck.tools.role;


import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(generator = "uid-generator")
    @GenericGenerator(
        name = "uid-generator",
        strategy = "ck.tools.uid.IdGenerator"
    )
    private Long id;
    private String name;
}
