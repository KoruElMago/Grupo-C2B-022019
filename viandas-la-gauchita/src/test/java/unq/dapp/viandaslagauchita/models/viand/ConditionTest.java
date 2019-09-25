package unq.dapp.viandaslagauchita.models.viand;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import unq.dapp.viandaslagauchita.models.viand.Category;
import unq.dapp.viandaslagauchita.models.viand.Viand;
import unq.dapp.viandaslagauchita.models.viand.condition.BuyCondition;
import unq.dapp.viandaslagauchita.models.viand.condition.Condition;

import java.sql.Time;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQueries;
import java.util.*;

//@ContextConfiguration
//@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class,
//        StepScopeTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class ConditionTest {

    //------------------------Test de Viandas Validas----------------------------
    @Test
    public void testConditionDefaultConBuyVacia(){
        Buy buy = Mockito.mock(Buy.class);
        Mockito.when(buy.getShopping()).thenReturn( Collections.emptyMap());
        Condition cond = new BuyCondition();
        Assert.assertFalse( cond.applyBuy(buy) );
    }

    @Test
    public void testConditionDefaultConBuyDeUnElementoNulo(){
        Buy buy = Mockito.mock(Buy.class);
        Viand viand = Mockito.mock(Viand.class);
        Map<Viand,Integer> mapa = new HashMap<>();
            mapa.put(viand,0); //Esto se espera que nunca pase

        Mockito.when( buy.getShopping() ).thenReturn( mapa );
        Condition cond = new BuyCondition();
        Assert.assertFalse( cond.applyBuy( buy ) );
    }

    @Test
    public void testConditionCompletoConBuyVaciaYDeUnElementoNulo(){
        Buy buy = Mockito.mock(Buy.class);
        Viand viand = Mockito.mock(Viand.class);

        Map<Viand,Integer> mapa = new HashMap<>();
        mapa.put(viand,0); //Esto se espera que nunca pase

        Condition cond = new BuyCondition();

        Mockito.when(buy.getShopping()).thenReturn( Collections.emptyMap());
        Assert.assertFalse( cond.applyBuy( buy ) );

        Mockito.when( buy.getShopping() ).thenReturn( mapa );
        Assert.assertFalse( cond.applyBuy( buy ) );
    }

    //----------------------Test de fechas y dias validas para ConditionBuy por default-----------
    @Test
    public void testConditionDefaultConBuyViandasValidasAntesDelIntervaloDe2hrs(){
        Buy buy = Mockito.mock(Buy.class);

        Viand viand = Mockito.mock(Viand.class);
        Map<Viand,Integer> mapa = new HashMap<>();
        mapa.put(viand,1);
        Time horarioActualmenos5min = Time.valueOf( LocalTime.now().minusMinutes(5) );

        Mockito.when( buy.getShopping() ).thenReturn( mapa );
        Mockito.when( buy.getTimeOfDeliver() ).thenReturn( horarioActualmenos5min );
        Mockito.when( buy.getDateOfDeliver() ).thenReturn( Date.from( Instant.now() ) );

        Condition cond = new BuyCondition();

        Assert.assertFalse( "El horario de delivery debia ser en el pasado "
                , cond.applyBuy( buy ) );
    }

    @Test
    public void testConditionDefaultConBuyViandasValidasDentroDeIntervaloDe2hrs(){
        Buy buy = Mockito.mock(Buy.class);

        Viand viand = Mockito.mock(Viand.class);
        Map<Viand,Integer> mapa = new HashMap<>();
            mapa.put(viand,1);

        Mockito.when( buy.getShopping() ).thenReturn( mapa );
        Mockito.when( buy.getTimeOfDeliver() ).thenReturn( Time.valueOf( LocalTime.now() ) );
        Mockito.when( buy.getDateOfDeliver() ).thenReturn( Date.from( Instant.now() ) );

        Condition cond = new BuyCondition();

        Assert.assertFalse( "El horario de delivery debia ser antes de las 2hr minimas "
                , cond.applyBuy( buy ) );
    }

    @Test
    public void testConditionDefaultConBuyViandasValidasLuegoDelIntervaloDe2hrs(){
        Buy buy = Mockito.mock(Buy.class);

        Viand viand = Mockito.mock(Viand.class);
        Map<Viand,Integer> mapa = new HashMap<>();
        mapa.put(viand,1);
        Time horarioActualMas2hr1Min = Time.valueOf( LocalTime.now().plusHours(2).plusMinutes(1) );

        Mockito.when( buy.getShopping() ).thenReturn( mapa );
        Mockito.when( buy.getTimeOfDeliver() ).thenReturn( horarioActualMas2hr1Min );
        Mockito.when( buy.getDateOfDeliver() ).thenReturn( Date.from( Instant.now() ) );

        Condition cond = new BuyCondition();

        Assert.assertTrue( "El horario de delivery debia estar luego de 2hr "
                , cond.applyBuy( buy ) );
    }

    @Test
    public void testConditionDefaultConBuyViandasValidasParaOtroDia(){
        Buy buy = Mockito.mock(Buy.class);

        Viand viand = Mockito.mock(Viand.class);
        Map<Viand,Integer> mapa = new HashMap<>();
        mapa.put(viand,1);

        Calendar cal;

        Mockito.when( buy.getShopping() ).thenReturn( mapa );
        Mockito.when( buy.getTimeOfDeliver() ).thenReturn( Time.valueOf( LocalTime.now() ) );

        Condition cond = new BuyCondition();

        cal = Calendar.getInstance();
        cal.setTime( Date.from( Instant.now()) );
        cal.add(Calendar.DATE, 1);    //Siguiente dia para el delivery
        Mockito.when( buy.getDateOfDeliver() ).thenReturn( cal.getTime() );

        Assert.assertTrue( "El dia de delivery debia ser mañana", cond.applyBuy( buy ) );

        cal = Calendar.getInstance();
        cal.setTime( Date.from( Instant.now()) );
        cal.add(Calendar.DATE, -1);    //Ayer era el dia para el delivery
        Mockito.when( buy.getDateOfDeliver() ).thenReturn( cal.getTime() );

        Assert.assertFalse( "El dia de delivery no puede ser ayer", cond.applyBuy( buy ) );
    }

    //----------------------Test de fechas y dias validas para ConditionBuy personalizado-----------
    //Considero que como se testearon todos los casos de fecha y hora de este momento, cambiarlos seguiran dando bien.

}
