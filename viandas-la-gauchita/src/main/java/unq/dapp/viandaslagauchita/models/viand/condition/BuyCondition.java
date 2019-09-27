package unq.dapp.viandaslagauchita.models.viand.condition;

import unq.dapp.viandaslagauchita.models.viand.Buy;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;

public class BuyCondition implements Condition {

    private Date deliveryDay;
    private Time deliveryTime;

    public BuyCondition(){
        deliveryDay  = Date.from( Instant.now() );
        deliveryTime = Time.valueOf( LocalTime.now() );
    }

    public BuyCondition(Date deliveryDay, Time deliveryTime){
        this.deliveryDay  = deliveryDay;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public boolean applyBuy(Buy buy) {

        return !buy.getShopping().isEmpty() && allQuantitysArePositive(buy.getShopping().values()) && timeIsOutsideOf2hLimit(buy);
    }

    private boolean allQuantitysArePositive(Collection<Integer> quantitys){
        return quantitys.stream().allMatch( integer -> integer > 0 );
    }

    private boolean timeIsOutsideOf2hLimit(Buy buy){
        return deliveryDay.before( buy.getDateOfDeliver() ) ||
                deliveryDay.compareTo( buy.getDateOfDeliver() ) == 0 &&
                deliveryTime.toLocalTime().plusHours(2).isBefore(buy.getTimeOfDeliver().toLocalTime()); //Se tiene que sumar 2h
    }
}
