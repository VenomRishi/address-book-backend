package com.bridgelabz.addressbook.builder;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBookDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressBuilder {

  public AddressBookDO buildDO(AddressBookDTO addressBookDTO) {
    AddressBookDO addressBookDO = new AddressBookDO();
    BeanUtils.copyProperties(addressBookDTO, addressBookDO);
    return addressBookDO;
  }
}
