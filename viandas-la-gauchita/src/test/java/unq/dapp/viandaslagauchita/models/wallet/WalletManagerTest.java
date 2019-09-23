package unq.dapp.viandaslagauchita.models.wallet;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class WalletManagerTest {

    @Test
    public void applyTransactionTest(){
        Wallet buyer = Wallet.builder().build();
        Wallet seller = Wallet.builder().build();

        buyer.applyTransaction(15.0f);

        WalletTransaccionManager.applyTransaction(buyer,seller,10.0f);

        Assert.assertEquals(buyer.getBalance(), (Float) 5.0f);
        Assert.assertEquals(seller.getBalance(), (Float) 10.0f);

    }

    @Test(expected = NegativeWalletException.class)
    public void failedTransactionTest(){
        Wallet buyer = Wallet.builder().build();
        Wallet seller = Wallet.builder().build();

        buyer.applyTransaction(15.0f);

        WalletTransaccionManager.applyTransaction(buyer,seller,30.0f);

    }
}