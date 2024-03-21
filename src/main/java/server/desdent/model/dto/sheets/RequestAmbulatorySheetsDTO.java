package server.desdent.model.dto.sheets;

import lombok.Data;

import java.util.Date;

@Data
public class RequestAmbulatorySheetsDTO {

    private Long dentistId;

    private Long patientId;

    private int ambSheetNo;

    private String healthInsBookletNo;

    private String allergy;

    private String pastDiseases;

    private String presentDiseases;

    private Date issueDate;

    private String diagnosis;

    private String toothCode;

    private String activity;

    private String activityCode;

    private String minutes;
}
