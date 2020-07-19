package com.myride.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
private String ownerId;
private String firstName;
private String lastName;
private Address address;
private String phone;
private String emailId;
}
