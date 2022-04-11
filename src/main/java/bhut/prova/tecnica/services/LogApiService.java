package bhut.prova.tecnica.services;

import bhut.prova.tecnica.models.LogApi;
import bhut.prova.tecnica.repositories.LogApiRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class LogApiService {

    private final LogApiRepository logApiRepository;

    public LogApiService(LogApiRepository logApiRepository) {
        this.logApiRepository = logApiRepository;
    }

    public UUID addLogApi (LogApi logApi){
        logApi = logApiRepository.save(logApi);
        return logApi.getId();
    }

    public Collection<LogApi> getLogsApi(){
        return logApiRepository.findAll();
    }
}
