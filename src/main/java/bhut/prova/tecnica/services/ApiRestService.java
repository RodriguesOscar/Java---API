package bhut.prova.tecnica.services;

import bhut.prova.tecnica.models.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class ApiRestService {

    private final WebClient webClient;

    public ApiRestService(WebClient.Builder builder) {
        webClient = builder.baseUrl("http://api-test.bhut.com.br:3000").build();
    }

    public Flux<Car> listCars(){

        log.info("serviço para buscar todos os carros");

        return webClient
                .get()
                .uri("/api/cars")
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Erro na requisição: verifique os parâmetros da busca.")))
                .bodyToFlux(Car.class)
                .timeout(Duration.ofMillis(10_000));
    }

    public Mono<Car> createCar(Car car){

        log.info("serviço para criar um novo carro");

        return webClient.post()
                .uri("/api/cars")
                .body(Mono.just(car), Car.class)
                .retrieve()
                .bodyToMono(Car.class)
                .timeout(Duration.ofMillis(10_000));
    }

}
