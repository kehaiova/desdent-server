package server.desdent.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name = "schedule")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_visit")
    private Date visitDate;

    @ManyToOne
    @MapsId("dentist_id")
    @JsonManagedReference
    @JoinColumn(name = "dentist_id")
    Dentists dentist;

    @ManyToOne
    @MapsId("patient_id")
    @JsonManagedReference
    @JoinColumn(name = "patient_id")
    Patients patient;
}
