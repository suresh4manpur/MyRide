package com.myride.registration.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
private String addressId;
private String addressLine1;
private String addressLine2;
private String district;
private String state;
private String country;
private String city;
private String pinCode;

}
