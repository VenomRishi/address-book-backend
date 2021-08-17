package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {

  private int id;
  private String name;
  private String address;
  private String city;
  private String state;
  private String phoneNumber;
  private int zip;
}
