package unq.dapp.viandaslagauchita.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
public class Provider {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String url_logo;
    private Address address;
    private String description;
    private String url_web;
    private String email;
    private String telphone;
    private String attention_schedule;
    private Address delivery_address;

}
