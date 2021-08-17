package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import java.util.List;

public interface IAddressBookService {

  List<AddressBookDTO> getAddresses();

  AddressBookDTO addAddressBook(AddressBookDTO addressBookDTO);

  AddressBookDTO updateAddressBook(int id, AddressBookDTO addressBookDTO);
}
