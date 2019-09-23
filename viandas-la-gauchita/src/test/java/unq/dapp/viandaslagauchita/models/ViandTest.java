package unq.dapp.viandaslagauchita.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import unq.dapp.viandaslagauchita.models.viand.Viand;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//@ContextConfiguration
//@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class,
//        StepScopeTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class ViandTest {

    private Set<String> categorias;
    private LocalDate from,until;
    private Long idForzada = 1l;

    @Before
    public void setUp(){
        categorias = new HashSet<>();
        categorias.add("Sushi");
        from = LocalDate.parse("2018-05-05");
        until= LocalDate.parse("2019-05-05");
    }


    @Test
    public void testCreacionDeViandaConBuilderMinima(){
        Viand vianda = Viand.builder()
                .name("Vianda").description("Corporativa")
                .categories(categorias)
                .from(from).until(until)
                .price(20f).deliveryPrice(15f)
                .cantMin1(20).priceMin1(20f)
                .cantMaxSales(30)
                .build();

        Assert.assertEquals("Vianda", vianda.getName());
        Assert.assertEquals("Corporativa",vianda.getDescription() );
        Assert.assertEquals(categorias, vianda.getCategories() );
        Assert.assertEquals(15f, vianda.getDeliveryPrice(), 0.000001 );
        Assert.assertEquals(from, vianda.getFrom() );
        Assert.assertEquals(until, vianda.getUntil());

        //Esta forma de testear no tiene ambiguedad entre float, double y Object, ni Long y Object
        assertThat(vianda.getPrice()).isEqualTo(20f);
        assertThat(vianda.getCantMin1()).isEqualTo(20);
        assertThat(vianda.getPriceMin1()).isEqualTo(20f);
        assertThat(vianda.getCantMaxSales()).isEqualTo(30);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testCreacionDeViandaConBuilderIncompleto(){
        Viand.builder().build();
    }


    @Test
    public void testCreacionDeViandaConBuilderCompleto(){
        Viand vianda = Viand.builder()
                .name("Vianda").description("Corporativa")
                .categories(categorias)
                .from(from).until(until)
                .hourBand(5f).meanTimeToDeliver(0.5f)   //Parametros opcionales
                .price(20f).deliveryPrice(15f)
                .cantMin1(20).priceMin1(20f)
                .cantMin2(30).priceMin2(30f)            //Parametros opcionales
                .cantMaxSales(30)
                .build();



        Assert.assertEquals("Vianda", vianda.getName());
        Assert.assertEquals("Corporativa",vianda.getDescription() );
        Assert.assertEquals(categorias, vianda.getCategories() );
        Assert.assertEquals(15f, vianda.getDeliveryPrice(), 0.000001 );
        Assert.assertEquals(from, vianda.getFrom() );
        Assert.assertEquals(until, vianda.getUntil());

        //Esta forma de testear no tiene ambiguedad entre float, double y Object, ni Long y Object
        assertThat(vianda.getPrice()).isEqualTo(20f);
        assertThat(vianda.getCantMin1()).isEqualTo(20);
        assertThat(vianda.getPriceMin1()).isEqualTo(20f);
        assertThat(vianda.getCantMaxSales()).isEqualTo(30);

        //Los opcionales
        assertThat(vianda.getHourBand()).isEqualTo(5f);
        assertThat(vianda.getMeanTimeToDeliver()).isEqualTo(0.5f);
        assertThat(vianda.getPriceMin2()).isEqualTo(30f);
        assertThat(vianda.getCantMin2()).isEqualTo(30);
    }

    @Test
    public void testModificacionDeVianda(){
        Viand vianda = Viand.builder()
                .name("Vianda").description("Corporativa")
                .categories(categorias)
                .from(from).until(until)
                .hourBand(5f).meanTimeToDeliver(0.5f)   //Parametros opcionales
                .price(20f).deliveryPrice(15f)
                .cantMin1(20).priceMin1(20f)
                .cantMin2(30).priceMin2(30f)            //Parametros opcionales
                .cantMaxSales(30)
                .build();

        vianda.setDescription("Otra cosa");
        vianda.setCantMaxSales(100);


        Assert.assertEquals("Otra cosa",vianda.getDescription() );
        assertThat(vianda.getCantMaxSales()).isEqualTo(100);
    }
}
