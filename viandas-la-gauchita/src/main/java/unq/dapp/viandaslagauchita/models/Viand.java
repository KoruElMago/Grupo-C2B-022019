package unq.dapp.viandaslagauchita.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Viand {

    private @Id
    @GeneratedValue
    Long id;
    private @NonNull String name;
    private @NonNull String description;
    private @NonNull Set categories;    //TODO:Discutir como crear los sub tipos
    private @NonNull String deliveryPrice;

    private @NonNull Date from, until;
    private Float hourBand;
    private Float meanTimeToDeliver;  //TODO:Escojer un mejor tipo

    private @NonNull Float price;
    private @NonNull Integer cantMin1;
    private @NonNull Float priceMin1;
    private          Integer cantMin2;
    private          Float priceMin2;
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