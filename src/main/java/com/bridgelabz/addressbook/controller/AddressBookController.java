package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.service.IAddressBookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AddressBookController {

  @Autowired
  private IAddressBookService iAddressBookService;

  @GetMapping(value = "/addresses")
  public ResponseEntity<List<AddressBookDTO>> getAddresses() {
    return new ResponseEntity<>(iAddressBookService.getAddresses(), HttpStatus.OK);
  }

  @PostMapping(value = "/address")
  public ResponseEntity<AddressBookDTO> addAddressBook(@RequestBody AddressBookDTO addressBookDTO) {
    return new ResponseEntity<>(iAddressBookService.addAddressBook(addressBookDTO), HttpStatus.CREATED);
  }

  @PutMapping(value = "/address")
  public ResponseEntity<AddressBookDTO> updateAddressBook(@RequestParam(name = "id") final int id, @RequestBody AddressBookDTO addressBookDTO) {
    return new ResponseEntity<>(iAddressBookService.updateAddressBook(id, addressBookDTO), HttpStatus.OK);
  }
}
