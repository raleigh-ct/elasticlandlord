package com.elasticlandlord.model.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterFormDTO extends LoginFormDTO {

    //fields for user registration form
    private String verifyPassword;

    @NotNull
    @Size(min=2, max=50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotNull
    @Size(min=2, max=50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotNull
    @Email
    private String email;

    private String phoneNumber;

    //getters&setters
    public String getVerifyPassword() {
        return verifyPassword;
    }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

}
