package unq.dapp.viandaslagauchita.models.wallet;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Data
@Getter
@Builder
public class Wallet {

    @Builder.Default
    private Float balance  = 0.0f;

    public void applyTransaction(float amount){
        if((this.balance + amount) < 0 ){
            throw new NegativeWalletException();
        }
        this.balance += amount;
    }
}
