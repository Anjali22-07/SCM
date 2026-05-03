package com.scm.smartcontactmanager.Forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserForm {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message="Email is required")
    @Email(message="Invalid Email")
    private String email;
    @NotBlank(message="Password is required")
    @Size(min=8 , message = "Password must Contain min 8 character/numbers/symbols"  )
    private String password;
    @NotBlank(message="Phone number is required")
    private String phoneNumber;
    private String about;

}
