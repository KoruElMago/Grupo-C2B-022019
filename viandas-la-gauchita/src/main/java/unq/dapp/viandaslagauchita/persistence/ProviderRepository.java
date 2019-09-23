package unq.dapp.viandaslagauchita.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import unq.dapp.viandaslagauchita.models.user.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Long> {


}
