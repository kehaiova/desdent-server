package server.desdent.model.dto.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DentistWithoutPasswordDTO {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String address;
    private String roleName;


}
