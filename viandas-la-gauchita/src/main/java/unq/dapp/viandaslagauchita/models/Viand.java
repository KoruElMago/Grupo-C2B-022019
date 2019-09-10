package unq.dapp.viandaslagauchita.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public
class Viand {

    private @Id @GeneratedValue Long id;
    private String name;
    private String description;

    public Viand() {}

    public Viand(String name, String description) {
        this.name = name;
        this.description = description;
    }
}