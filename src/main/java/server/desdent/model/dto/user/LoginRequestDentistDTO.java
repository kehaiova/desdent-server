package server.desdent.model.dto.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDentistDTO {

    @NotBlank(message = "Email is mandatory!")
    @Email(message = "Invalid email format.")
    private String username;
    @NotBlank(message = "Password is mandatory!")
    private String password;
}
