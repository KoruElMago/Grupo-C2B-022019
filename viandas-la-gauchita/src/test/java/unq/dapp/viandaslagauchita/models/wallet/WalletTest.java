package unq.dapp.viandaslagauchita.models.wallet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class WalletTest {

    @Test
    public void testCreateWalllet(){
        Wallet wallet = Wallet.builder().build();
        Float initialValue = 0.0f;

        Assert.assertEquals(wallet.getBalance(),initialValue);
    }


    @Test
    public void testApplyPositiveTransacction(){
        Wallet wallet = Wallet.builder().build();
        Float initialValue = 0.0f;

        Assert.assertEquals(wallet.getBalance(),initialValue);
        Float amountToApply = 5.0f;

        wallet.applyTransaction(amountToApply);

        Assert.assertEquals(wallet.getBalance(),amountToApply);

    }
}
