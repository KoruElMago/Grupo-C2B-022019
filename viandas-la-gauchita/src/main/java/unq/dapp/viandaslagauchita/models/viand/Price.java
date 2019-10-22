package unq.dapp.viandaslagauchita.models.viand;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import unq.dapp.viandaslagauchita.models.viand.condition.Condition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Getter
public class Price {

    private @Id
    @GeneratedValue
    Long id;

    private Float amount;

    @Builder.Default
    private List<Condition> conditions = new ArrayList<Condition>();

    public boolean matchConditions(Buy buy){
        return conditions.stream().allMatch(condition -> condition.applyBuy(buy));
    }
}
