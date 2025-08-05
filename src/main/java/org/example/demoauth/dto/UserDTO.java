package org.example.demoauth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.example.demoauth.util.Role;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private int id;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    private Role role = Role.USER;
}

















