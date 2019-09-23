package unq.dapp.viandaslagauchita.models.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import unq.dapp.viandaslagauchita.models.user.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserRoleTest {

    @Test
    public void CanMakeProviderAnUser() {
        User user = User.builder().build();
        Role role = Provider.builder().build();
        Assert.assertFalse(user.hasRole(role));
        user.addRole(role);
        Assert.assertTrue(user.hasRole(role));
    }

    @Test(expected = AlreadyHasRoleExecption.class)
    public void AUserCantMakeProviderAnUserTwice() {
        User user = User.builder().build();
        Role role = Provider.builder().build();
        Assert.assertFalse(user.hasRole(role));
        user.addRole(role);
        Assert.assertTrue(user.hasRole(role));
        user.addRole(role);
    }

    @Test
    public void CanMakeClientAnUser() {
        User user = User.builder().build();
        Role role = Client.builder().build();
        Assert.assertFalse(user.hasRole(role));
        user.addRole(role);
        Assert.assertTrue(user.hasRole(role));
    }

    @Test(expected = AlreadyHasRoleExecption.class)
    public void AUserCantMakeClientAnUserTwice() {
        User user = User.builder().build();
        Role role = Client.builder().build();
        Assert.assertFalse(user.hasRole(role));
        user.addRole(role);
        Assert.assertTrue(user.hasRole(role));
        user.addRole(role);
    }

    @Test
    public void CanMakeClientAndProviderAnUser() {
        User user = User.builder().build();
        Role provider = Provider.builder().build();
        Role client = Client.builder().build();

        Assert.assertFalse(user.hasRole(client));
        Assert.assertFalse(user.hasRole(provider));

        user.addRole(client);
        Assert.assertTrue(user.hasRole(client));
        Assert.assertFalse(user.hasRole(provider));

        user.addRole(provider);
        Assert.assertTrue(user.hasRole(client));
        Assert.assertTrue(user.hasRole(provider));

    }
}