package unq.dapp.viandaslagauchita.models;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

//@ContextConfiguration
//@TestExecutionListeners( { DependencyInjectionTestExecutionListener.class,
//        StepScopeTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class ViandTest {

    private Set<String> categorias;

    @Before
    public void setUp(){
        categorias = new HashSet<>();
        categorias.add("Sushi");
    }

    @Test
    public void testCreacionDeVianda(){
        Viand vianda = new Viand("Vianda",
                             "Corporativa",
                                categorias,
                             15f,
                                LocalDate.parse("2018-05-05"), LocalDate.parse("2018-05-05"),
                            20f, 20,
                            30f , 30);

        assertThat(vianda.getName()).isEqualTo("Vianda");

        //assertEquals
    }
}
