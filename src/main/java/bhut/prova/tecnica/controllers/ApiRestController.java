package bhut.prova.tecnica.controllers;

import bhut.prova.tecnica.models.Car;
import bhut.prova.tecnica.models.LogApi;
import bhut.prova.tecnica.services.ApiRestService;
import bhut.prova.tecnica.services.LogApiService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ApiRestController {

    private final ApiRestService apiRestService;
    private final LogApiService logApiService;

    public ApiRestController(ApiRestService apiRestService, LogApiService logApiService){
        this.apiRestService = apiRestService;
        this.logApiService = logApiService;
    }

    @GetMapping("/listCars")
    public Flux<Car> listCars(){
        return apiRestService.listCars();
    }

    @PostMapping("/createCar")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Car> createCar(@RequestBody Car car){

        UUID mainLogApi = logApiService.addLogApi(new LogApi(null, LocalDateTime.now(), "Criando carro:", null, null));

        try {
            logApiService.addLogApi(new LogApi(null, LocalDateTime.now(), "Carro criado com o id:" + car.get_id(), car.get_id(), mainLogApi));
            return apiRestService.createCar(car);
        } catch (Exception e){
            logApiService.addLogApi(new LogApi(null, LocalDateTime.now(), "Erro ao criar o carro:" + e.getMessage(), null, mainLogApi));
            return Mono.error(new RuntimeException());
        }
    }

    @GetMapping("/logs")
    public ResponseEntity<Collection<LogApi>> getLogs(){
        try{
            Collection<LogApi> logs = logApiService.getLogsApi();
            return ResponseEntity.ok(logs);
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

}
