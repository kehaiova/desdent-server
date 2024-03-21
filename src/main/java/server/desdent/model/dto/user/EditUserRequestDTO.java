package server.desdent.model.dto.user;

import lombok.Data;

@Data
public class EditUserRequestDTO {
    private String username;

    private String address;

    private String emailAddress;

    private String phoneNum;

}
