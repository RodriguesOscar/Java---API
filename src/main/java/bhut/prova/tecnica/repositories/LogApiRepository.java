package bhut.prova.tecnica.repositories;

import bhut.prova.tecnica.models.LogApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogApiRepository extends JpaRepository<LogApi, UUID> { }
