package unq.dapp.viandaslagauchita.webservice;

public class ViandNotFoundException extends RuntimeException {
    public ViandNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
