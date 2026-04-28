package com.gohar.customer.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
         String id,
         @NotNull(message = "Customer name required")
         String name,
         @NotNull(message = "Customer email required")
         @Email(message = "Customer email is not a valid email address")
         String email,
         Address address
) {
}
