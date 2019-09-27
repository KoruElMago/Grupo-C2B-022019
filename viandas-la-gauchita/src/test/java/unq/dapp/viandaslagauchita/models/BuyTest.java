package unq.dapp.viandaslagauchita.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import unq.dapp.viandaslagauchita.models.user.Provider;
import unq.dapp.viandaslagauchita.models.viand.Buy;
import unq.dapp.viandaslagauchita.models.viand.TypeOfDelivery;
import unq.dapp.viandaslagauchita.models.viand.Viand;
import java.sql.Time;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class BuyTest {

    private Provider proveedor;
    private Viand vianda;

    @Before
    public void setUp(){
        proveedor = Mockito.mock(Provider.class);
        vianda = Mockito.mock(Viand.class);
    }

    @Test
    public void testHacerCompraVacia(){
        Buy compra = Buy.builder().service(proveedor).build();

        Assert.assertEquals(proveedor, compra.getService());
        Assert.assertTrue( compra.getViand().isEmpty() );
        Assert.assertNull( compra.getDateOfDeliver() );
        Assert.assertNull( compra.getTimeOfDeliver() );
        Assert.assertNull( compra.getDeliveryType() );
    }

    @Test(expected = NullPointerException.class)
    public void testCompraIncompleta(){
        Buy.builder().build();
    }

    @Test
    public void testHacerCompraCon20Viandas(){
        Buy compra = Buy.builder().service(proveedor).build();
        compra.addViand(vianda,20);

        Assert.assertFalse( compra.getViand().isEmpty() );
        Assert.assertEquals( ((int) 20) , ((int) compra.getShopping().get(vianda) ) );
    }

    @Test
    public void testHacerCompraEn2Pasos(){
        Buy compra = Buy.builder().service(proveedor).build();

        compra.addViand(vianda,10);
        compra.addViand(vianda,10);

        Assert.assertEquals( 1, compra.getViand().size() );
        Assert.assertEquals( ((int) 20) , ((int) compra.getShopping().get(vianda) ) );
    }

    @Test
    public void testHacerCompraYQuitarViandas(){
        Buy compra = Buy.builder().service(proveedor).build();

        compra.addViand(vianda,20);
        Assert.assertEquals( ((int) 20) , ((int) compra.getShopping().get(vianda) ) );
        Assert.assertEquals( 1, compra.getViand().size() );

        compra.removeViand(vianda,10);

        Assert.assertEquals( 1, compra.getViand().size() );
        Assert.assertEquals( ((int) 10) , ((int) compra.getShopping().get(vianda) ) );
    }

    @Test
    public void testHacerCompraCompleta(){
        Date fecha = new Date();
        TypeOfDelivery tipo = new TypeOfDelivery();
        Time momento = Mockito.mock(Time.class);

        Buy compra = Buy.builder()
                        .service(proveedor)
                        .dateOfDeliver(fecha)
                        .deliveryType(tipo)
                        .timeOfDeliver(momento)
                        .build();

        Assert.assertEquals( fecha, compra.getDateOfDeliver() );
        Assert.assertEquals( momento, compra.getTimeOfDeliver() );
        Assert.assertEquals( tipo, compra.getDeliveryType() );
    }
}
