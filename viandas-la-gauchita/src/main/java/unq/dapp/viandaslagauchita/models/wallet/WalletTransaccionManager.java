package unq.dapp.viandaslagauchita.models.wallet;

public class WalletTransaccionManager {

    public static void applyTransaction(Wallet buyer, Wallet seller, Float amount){
        buyer.applyTransaction(amount * -1);
        seller.applyTransaction(amount);
    }
}
