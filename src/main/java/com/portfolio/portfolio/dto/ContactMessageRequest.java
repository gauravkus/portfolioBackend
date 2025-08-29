package com.portfolio.portfolio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactMessageRequest {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2–50 characters")
    private  String name;
    @Email(message = "Email should be valid")
    @NotBlank
    private  String email;
    @NotBlank
    private  String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ContactMessageRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
