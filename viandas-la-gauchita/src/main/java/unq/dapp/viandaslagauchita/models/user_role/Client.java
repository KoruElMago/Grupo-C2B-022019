package unq.dapp.viandaslagauchita.models.user_role;

import lombok.Builder;
import lombok.Getter;
import unq.dapp.viandaslagauchita.models.Buy;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
public class Client extends Role {


    public boolean canBuy() {
        return true;
    }

    @Override
    public String roleName() {
        return "Client";
    }

}
