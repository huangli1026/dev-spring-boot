package com.huangli.springdemo.mvc;

import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min = 1, message = "Min > 1 is required")
    private String lastName;

    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

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
//重复的验证注解：freePasses 字段的验证注解被添加到了字段、getter 方法和 setter 方法上。通常，验证注解只需要在字段上，
// 或在 getter 方法上（如果你的框架依赖于 getter 方法进行验证）。在 setter 方法上再次添加这些注解可能会导致重复的验证。
    @Min(value = 0, message = "must be greater than or equal to zero")
    @Max(value = 10, message = "must be less than or equal to 10")
    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(@Min(value = 1, message = "must be greater than or equal to zero") @Max(value = 10, message = "must be less than or equal to 10") Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
