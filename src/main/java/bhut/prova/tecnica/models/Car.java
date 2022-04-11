package bhut.prova.tecnica.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Car {
    private String _id;
    private String title;
    private String brand;
    private String price;
    private Integer age;
    private Integer __v;

}
