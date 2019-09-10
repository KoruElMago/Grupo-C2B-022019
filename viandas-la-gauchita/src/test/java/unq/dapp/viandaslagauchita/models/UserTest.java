package unq.dapp.viandaslagauchita.models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

    @Mock
    Address address;

    @Test
    public void canCreateUser() {
        User user = User.builder()
                .name("foo")
                .address(address)
                .telphone("12312312")
                .email("mail_test@tes.com")
                .build();

        Assert.assertEquals("foo", user.getName());

    }
}
