package unq.dapp.viandaslagauchita.models.user_role;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Entity;

@Getter
@Data
@Entity
public abstract class Role {

    public boolean canPublishViand() {
        return false;
    }

    public boolean canBuy() {
        return false;
    }

    public boolean sameRole(Role role) {
        return roleName().equals(role.roleName());
    }
    public abstract String roleName();
}
