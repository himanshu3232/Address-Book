package com.capgemini.address_book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(value = 1, message = "Id cannot be less than 1")
    private Long id;
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Invalid name size")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name cannot contain numbers!")
    private String name;
    @NotBlank(message = "Address cannot be blank")
    @Size(min = 5, message = "Invalid address size")
    private String address;
}
