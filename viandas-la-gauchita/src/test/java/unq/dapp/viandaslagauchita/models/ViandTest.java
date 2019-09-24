package unq.dapp.viandaslagauchita.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import unq.dapp.viandaslagauchita.models.viand.Category;
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

    private Set<Category> categorias;
    private LocalDate from,until;

    public void init(){
        categorias = new HashSet<>();
        categorias.add(Category.Sushi);
        from = LocalDate.parse("2018-05-05");
        until= LocalDate.parse("2019-05-05");
    }


    @Test
    public void testCreacionDeViandaConBuilderMinima(){
        init();
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

        Assert.assertEquals( ((float) 20.0f), (float) vianda.getPrice(),Float.MIN_NORMAL);
        Assert.assertEquals(((long)20), (long) vianda.getCantMin1() );
        Assert.assertEquals( ((float) 20.0f), (float) vianda.getPriceMin1(),Float.MIN_NORMAL);
        Assert.assertEquals(((long)30), (long) vianda.getCantMaxSales() );
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testCreacionDeViandaConBuilderIncompleto(){
        init();
        Viand.builder().build();
    }


    @Test
    public void testCreacionDeViandaConBuilderCompleto(){
        init();
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

        Assert.assertEquals( ((float) 20.0f), (float) vianda.getPrice(),Float.MIN_NORMAL);
        Assert.assertEquals(((long)20), (long) vianda.getCantMin1() );
        Assert.assertEquals( ((float) 20.0f), (float) vianda.getPriceMin1(),Float.MIN_NORMAL);
        Assert.assertEquals(((long)30), (long) vianda.getCantMaxSales() );

        //Los opcionales
        Assert.assertEquals( ((float) 5f), (float) vianda.getHourBand(),Float.MIN_NORMAL);
        Assert.assertEquals( ((float) .5f), (float) vianda.getMeanTimeToDeliver(),Float.MIN_NORMAL);
        Assert.assertEquals( ((float) 30.0f), (float) vianda.getPriceMin2(),Float.MIN_NORMAL);
        Assert.assertEquals(((long)30), (long) vianda.getCantMin2() );
    }

    @Test
    public void testModificacionDeVianda(){
        init();
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
        Assert.assertEquals(((long)100), (long) vianda.getCantMaxSales() );
    }
}
