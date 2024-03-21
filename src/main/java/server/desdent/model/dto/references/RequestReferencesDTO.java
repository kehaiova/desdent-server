package server.desdent.model.dto.references;

import lombok.Data;

import java.util.Date;

@Data
public class RequestReferencesDTO {

    private Long dentistId;
    private Date startDate;
    private Date endDate;
}
