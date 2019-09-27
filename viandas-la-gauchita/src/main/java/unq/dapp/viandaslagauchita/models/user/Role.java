package unq.dapp.viandaslagauchita.models.user;

import lombok.*;

@Getter
@Data
@AllArgsConstructor
public abstract class Role {

    @NonNull
    private String roleName;

    public boolean canPublishViand() {
        return false;
    }

    public boolean canBuy() {
        return false;
    }

    public boolean sameRole(Role role) {
        return getRoleName().equals(role.getRoleName());
    }
}
