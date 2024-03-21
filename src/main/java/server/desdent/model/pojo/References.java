package server.desdent.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name = "V_REFERENCES")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class References {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "PATIENT_IDENTIFIER")
    private String personIdentificator;

    @Column(name = "PATIENT_NAME")
    private String personNames;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @Column(name = "AMB_SHEET_NO")
    private String ambSheetNo;

    @Column(name = "HEALTH_INS_BOOKLET_NO")
    private String healthInsBookletNo;

    @Column(name = "ALERGY")
    private String allergy;

    @Column(name = "PAST_DISEASES")
    private String pastDiseases;

    @Column(name="ISSUE_DATE")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date visitDate;

    @Column(name = "TOOTH_CODE")
    private String toothCode;

    @Column(name = "MINUTES")
    private String minutes;

    @Column(name="DENTIST_ID")
    private Long dentistId;
}
