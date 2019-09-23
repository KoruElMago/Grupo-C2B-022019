package unq.dapp.viandaslagauchita.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import unq.dapp.viandaslagauchita.models.user.Client;
import unq.dapp.viandaslagauchita.models.user.User;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
