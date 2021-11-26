package id.actualtraining.restwithjpa.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String password;
}
