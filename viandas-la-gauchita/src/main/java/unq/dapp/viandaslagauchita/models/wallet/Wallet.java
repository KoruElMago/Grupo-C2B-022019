package unq.dapp.viandaslagauchita.models.wallet;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Builder
public class Wallet {

    @Builder.Default
    private Float balance  = 0.0f;

    private @Id
    @GeneratedValue
    Long id;

    public void applyTransaction(float amount){
        if((this.balance + amount) < 0 ){
            throw new NegativeWalletException();
        }
        this.balance += amount;
    }

}
