package unq.dapp.viandaslagauchita.models.user_role;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import unq.dapp.viandaslagauchita.models.Address;

import javax.persistence.Entity;

@Entity
@Builder
@Getter
@Data
public class Provider extends Role {

    private String logo_url;
    private String location;
    private String delivery_location;
    private String web_page;
    private String delivery_schedules;


    public boolean canPublishViand() {
        return true;
    }

    @Override
    public String roleName() {
        return "Provider";
    }

}
