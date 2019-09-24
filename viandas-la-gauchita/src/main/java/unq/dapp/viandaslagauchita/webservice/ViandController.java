package unq.dapp.viandaslagauchita.webservice;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unq.dapp.viandaslagauchita.models.viand.Viand;
import unq.dapp.viandaslagauchita.persistence.ViandRepository;

@RestController
class ViandController {

    private final ViandRepository repository;

    ViandController(ViandRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/viands")
    List<Viand> all() {
        return repository.findAll();
    }

    @PostMapping("/viands")
    Viand newViand(@RequestBody Viand newViand) {
        return repository.save(newViand);
    }

    // Single item

    @GetMapping("/viands/{id}")
    Viand one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ViandNotFoundException(id));
    }

    @PutMapping("/viands/{id}")
    Viand replaceViand(@RequestBody Viand newViand, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newViand.getName());
                    employee.setDescription(newViand.getDescription());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newViand.setId(id);
                    return repository.save(newViand);
                });
    }

    @DeleteMapping("/viands/{id}")
    void deleteViand(@PathVariable Long id) {
        repository.deleteById(id);
    }
}