package unq.dapp.viandaslagauchita.models.user;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import unq.dapp.viandaslagauchita.models.Address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Builder
public class User {

    private @Id
    @GeneratedValue
    Long id;

    private String name;
    private String email;
    private String telphone;
    private Address address;
    @Builder.Default private List<Role> roles = new ArrayList<>();


    public void addRole(Role role) {
        if (!hasRole(role)) {
            roles.add(role);
        } else {
            throw new AlreadyHasRoleExecption();
        }
    }

    public boolean canPublishViand() {
        return roles.stream().anyMatch(Role::canPublishViand);
    }

    public boolean canBuy() {
        return roles.stream().anyMatch(Role::canBuy);
    }

    public boolean hasRole(Role role) {
        return roles.stream().anyMatch(r -> r.sameRole(role));
    }
}
