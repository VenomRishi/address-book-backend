package com.bridgelabz.addressbook.service;

import static org.junit.Assert.*;

import com.bridgelabz.addressbook.builder.AddressBuilder;
import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.repository.AddressBookRepo;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookServiceTest {

  @InjectMocks
  private AddressBookService addressBookService;
  @Mock
  private AddressBookRepo addressBookRepo;
  @Mock
  private ModelMapper modelMapper;
  @Mock
  private AddressBuilder addressBuilder;

  @Test
  public void getAddressesTest() {
    List<AddressBookDTO> addresses = addressBookService.getAddresses();
    assertNotNull(addresses);
  }
}
