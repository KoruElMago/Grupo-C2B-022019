package unq.dapp.viandaslagauchita.models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import unq.dapp.viandaslagauchita.models.user_role.AlreadyHasRoleExecption;
import unq.dapp.viandaslagauchita.models.user_role.Provider;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserRoleTest {

    @Test
    public void CanMakeProviderAnUser() {
        User user = User.builder().build();
        Provider role = Provider.builder().build();
        Assert.assertFalse(user.hasRole(role));
        user.addRole(role);
        Assert.assertTrue(user.hasRole(role));
    }

    @Test(expected = AlreadyHasRoleExecption.class)
    public void AUserCantMakeProviderAnUserTwice() {
        User user = User.builder().build();
        Provider role = Provider.builder().build();
        Assert.assertFalse(user.hasRole(role));
        user.addRole(role);
        Assert.assertTrue(user.hasRole(role));
        user.addRole(role);
    }
}