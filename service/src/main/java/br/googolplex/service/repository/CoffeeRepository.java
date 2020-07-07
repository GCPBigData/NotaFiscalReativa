package br.googolplex.service.repository;

/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 * Santiago Chile 07/07/2020
 */
import br.googolplex.service.entity.Coffee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CoffeeRepository extends ReactiveMongoRepository<Coffee, String> {
    Mono<Coffee> findOneByCoffeeType(String coffeeType);
}
