package unq.dapp.viandaslagauchita.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;
import java.util.Queue;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Buy {

    private @Id
            @GeneratedValue
            Long id;

    //Los compradores podrán comprar 1 menú (o más) del mismo servicio/negocio.

    private @NonNull Provider service;
    private @NonNull Queue<Pair<Viand,Integer>> shopping;  //Se debera comprobar que el entero es mayor a 0

    // Para hacer un pedido se deberá seleccionar Menú, Cantidad, TipoDeEntrega, FechaDeEntrega, HoraDeEntrega.
    private TypeOfEntrega entrega;
    private Date dateOfDeliver;
    private Time timeOfDeliver;
}


// Solo se podrán hacer pedidos hasta 48 horas antes de la fecha de la entrega, contemplando para el cálculo de los fechas, solo días hábiles (sugerencia: consumir servicio público para conocer feriados).
