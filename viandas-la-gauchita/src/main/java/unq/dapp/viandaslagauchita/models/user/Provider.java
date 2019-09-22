package unq.dapp.viandaslagauchita.models.user;

import lombok.*;
import unq.dapp.viandaslagauchita.models.Address;

import javax.persistence.Entity;

@Entity
@Getter
@Data
public class Provider extends Role {

    private String logo_url;
    private Address address;
    private String location;
    private String web_page;
    private String telphone_number;

    @Builder
    public Provider(String logo_url,
                    Address address,
                    String location,
                    String web_page,
                    String telphone_number) {
        super("Provider");
        this.logo_url = logo_url;
        this.address = address;
        this.location = location;
        this.web_page = web_page;
        this.telphone_number = telphone_number;
    }

    public boolean canPublishViand() {
        return true;
    }

}
