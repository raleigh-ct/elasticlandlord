package com.elasticlandlord.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractIdEntity{

    //fields
    @NotNull
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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

    @NotNull
    private String role;

    @NotNull
    private Boolean subscribed;


    //constructors
    public User(String username, String password, String role, Boolean subscribed, String firstName, String lastName, String email, String phoneNumber) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.role = "Property Manager";
        this.subscribed = false; // leave off for prototype?
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User(String registerFormDTOUsername, String registerFormDTOPassword, String firstName, String lastName, String username, String password) {};

    //getters&setters
    public String getUsername() {return username;}
    public String getRole() { return role; }
    public Boolean getSubscribed() { return subscribed; }
    public void setSubscribed(Boolean subscribed) { this.subscribed = subscribed; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    //methods
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}
