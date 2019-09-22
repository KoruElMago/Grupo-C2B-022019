package unq.dapp.viandaslagauchita.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import unq.dapp.viandaslagauchita.models.user.User;

public interface UserRepository extends JpaRepository<User, Long> {


}
