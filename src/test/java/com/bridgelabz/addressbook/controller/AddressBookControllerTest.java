package com.bridgelabz.addressbook.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.service.IAddressBookService;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class AddressBookControllerTest {

  @InjectMocks
  private AddressBookController addressBookController;
  @Mock
  private IAddressBookService iAddressBookService;

  @Test
  public void getAddressesTest() {
    when(iAddressBookService.getAddresses()).thenReturn(Lists.newArrayList(new AddressBookDTO()));
    ResponseEntity<List<AddressBookDTO>> responseEntity = addressBookController.getAddresses();
    assertNotNull(responseEntity);
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals(1, responseEntity.getBody().size());
  }
}
