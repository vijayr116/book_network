package com.vijay.book.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {
    @NotEmpty(message = "First Name is Mandatory")
    @NotBlank(message = "First Name is Mandatory")
    private String firstname;
    @NotEmpty(message = "Last Name is Mandatory")
    @NotBlank(message = "Last Name is Mandatory")
    private String lastname;
    @NotEmpty(message = "Email Name is Mandatory")
    @NotBlank(message = "Email Name is Mandatory")
    @Email(message = "Email Name is Not formatted")
    private String email;
    @NotEmpty(message = "Password Name is Mandatory")
    @NotBlank(message = "Password Name is Mandatory")
    @Size(message = "Password should be 8 characters long minimum")
    private String password;
}
