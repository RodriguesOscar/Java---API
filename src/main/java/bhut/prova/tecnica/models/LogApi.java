package bhut.prova.tecnica.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LogApi {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "unique-identifier")
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private LocalDateTime data_hora;

    @Column
    private String log;

    @Column
    private String car_id;

    @Column
    private UUID mainLogApi;

}
