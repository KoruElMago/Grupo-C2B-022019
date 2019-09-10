package unq.dapp.viandaslagauchita.persistence;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import unq.dapp.viandaslagauchita.models.Viand;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ViandRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Viand("Bilbo Baggel", "burglar")));
            log.info("Preloading " + repository.save(new Viand("Frodo Baggel", "thief")));
        };
    }
}