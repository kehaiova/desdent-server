package server.desdent.model.pojo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name = "AMB_SHEETS")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AmbulatorySheets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DENTIST_ID")
    private Long dentistId;

    @Column(name = "PERSON_ID")
    private Long personId;

    @Column(name="AMB_SHEET_NO")
    private Integer ambSheetNo;

    @Column(name="HEALTH_INS_BOOKLET_NO")
    private String healthInsBookletNo;

    @Column(name="ALERGY")
    private String allergy;

    @Column(name="PAST_DISEASES")
    private String pastDiseases;


    @Column(name="PRESENT_DISEASES")
    private String presentDiseases;

    @Column(name="ISSUE_DATE")
    private Date issueDate;

    @Column(name="DIAGNOSIS")
    private String diagnosis;


    @Column(name = "TOOTH_CODE")
    private String toothCode;

    @Column(name = "ACTIVITY")
    private String activity;

    @Column(name="ACTIVITY_CODE")
    private String activityCode;

    @Column(name="MINUTES")
    private String minutes;
}
