package unq.dapp.viandaslagauchita.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Getter
@Builder
public class User {

    private @Id
    @GeneratedValue
    Long id;

    @NonNull private String name;
    @NonNull private String email;
    @NonNull private String telphone;
    @NonNull private Address address;

}
