package unq.dapp.viandaslagauchita.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import unq.dapp.viandaslagauchita.models.user.Provider;
import unq.dapp.viandaslagauchita.models.viand.Buy;
import unq.dapp.viandaslagauchita.models.viand.Viand;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;

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
    public void testHacerCompra(){
        Buy compra = new Buy(proveedor);//proveedor,vianda,3,null,null,null);

        Assert.assertEquals(compra.getService(),proveedor);
        Assert.assertTrue(compra.getViand().contains(vianda));
        Assert.assertEquals(compra.getViand().size(),1 );
    }
}
