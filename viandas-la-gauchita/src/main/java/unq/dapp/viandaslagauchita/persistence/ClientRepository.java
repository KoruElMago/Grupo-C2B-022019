package unq.dapp.viandaslagauchita.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import unq.dapp.viandaslagauchita.models.user.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
