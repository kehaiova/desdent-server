package server.desdent.model.dto.patients;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RequestPatientsDTO {
    private String patientIdentifier;
}
