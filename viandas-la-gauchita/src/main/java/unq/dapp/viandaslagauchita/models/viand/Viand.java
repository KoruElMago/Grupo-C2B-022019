package unq.dapp.viandaslagauchita.models.viand;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import unq.dapp.viandaslagauchita.models.viand.condition.Condition;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.*;


@Data
@Entity
@Builder
public class Viand {

    private @Id
    @GeneratedValue
    Long id;

    @Builder.Default
    private List<Condition> conditions = new ArrayList<Condition>();
    @Builder.Default
    private List<Price> prices = new ArrayList<Price>();
    @Builder.Default
    private Set<Category> categories = new HashSet<Category>();

    public Float getPriceForBuy(Buy buy){
        Optional<Price> price = prices.stream().filter(price1 -> price1.matchConditions(buy)).findFirst();
        if (price.isEmpty()){
            throw new NoAvailabePrice();
        }
        return price.get().getAmount();
    }

    private @NonNull String name;
    private @NonNull String description;
    private @NonNull Float deliveryPrice;

    private @NonNull LocalDate from, until;
    private @Builder.Default Float hourBand = 1f;
    private @Builder.Default Float meanTimeToDeliver = 2f;  //TODO:Escojer un mejor tipo

    private @NonNull Float price;
    private @NonNull Integer cantMin1;
    private @NonNull Float priceMin1;
    private @Builder.Default Integer cantMin2 = null;
    private @Builder.Default Float priceMin2 = null;
    private @NonNull Integer cantMaxSales;

}

/*
Nombre del menú  [Obligatorio,4<=X<=30]
Descripción  [Obligatorio,20<=X<=40]
Categoría [Pizza-Cerveza-Hamburguesa-Sushi-Empanadas-Green-Vegano, Mínimo una opción]
Valor Delivery [Opcional,$10<=X<=$40]

Fecha de Vigencia desde y hasta [Obligatorio]
Turnos/Horarios de entrega/Envio
Tiempo promedio de entrega [Obligatorio]

Precio
Cantidad Mínima [Obligatorio, 10<=X<=70]
Precio Cantidad Minima  (*Min1) [Obligatorio,$0<=X<=$1000]
Cantidad Mínima 2 [Opcional, 40<=X<=150]
Precio Cantidad Minima 2(*Min2)  [Opcional,$0<=X<=$1000]
Cantidad  máxima de ventas por día [Obligatorio]

* */