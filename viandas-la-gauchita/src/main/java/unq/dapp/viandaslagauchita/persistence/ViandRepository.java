package unq.dapp.viandaslagauchita.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import unq.dapp.viandaslagauchita.models.*;

public interface ViandRepository extends JpaRepository<Viand, Long> {

}