package com.example.form_dang_ky.model;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private int id;
    @Size(min = 5, max = 45, message = "độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstName;
    @Size(min = 5, max = 45, message = "độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;
    @Pattern(regexp = "^([0-9]{10}$)", message = "Số điện thoại phải đủ 10 số")
    private String phoneNumber;
    @Min(value = 18 ,message = "từ 18 tuổi trở lên")
    private int age;
    @Email(message = "đúng đinh dạng email")
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {

    }
}
