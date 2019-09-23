package unq.dapp.viandaslagauchita.models.viand;


import lombok.*;
import org.springframework.data.util.Pair;
import unq.dapp.viandaslagauchita.models.user.Provider;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.*;

@Data
@Entity
@RequiredArgsConstructor
@Builder
public class Buy {

    private @Id
            @GeneratedValue
            Long id;

    //Los compradores podrán comprar 1 menú (o más) del mismo servicio/negocio.

    private @NonNull Provider service;

    @Builder.Default
    private Map<Viand,Integer> shopping = new HashMap<>();


    // Para hacer un pedido se deberá seleccionar Menú, Cantidad, TipoDeEntrega, FechaDeEntrega, HoraDeEntrega.
    private TypeOfDelivery deliveryType;
    private Date dateOfDeliver;
    private Time timeOfDeliver;

    public void addViand(Viand viand, Integer quantity){
        shopping.put(viand,shopping.getOrDefault(viand,0) + quantity);
    }

    public void removeViand(Viand viand, Integer quantity){
        if (shopping.getOrDefault(viand,0) <= quantity){
            shopping.remove(viand);
        }
    }

    public Set<Viand> getViand(){
        return shopping.keySet();
    }
}


// Solo se podrán hacer pedidos hasta 48 horas antes de la fecha de la entrega, contemplando para el cálculo de los fechas, solo días hábiles (sugerencia: consumir servicio público para conocer feriados).
