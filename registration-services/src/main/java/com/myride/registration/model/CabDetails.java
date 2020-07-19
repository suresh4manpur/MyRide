package com.myride.registration.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabDetails {
 private String cabId;
 private String cabNumber;
 private Date registratinoYear;
 //private Owner onwer;
}
